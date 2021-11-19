CREATE TABLE IF NOT EXISTS accounts
(
    id                bigserial          not null
        constraint accounts_table_pk primary key,

    email             VARCHAR(50) UNIQUE not null,
    telephone         VARCHAR(50),
    password          VARCHAR(500)       not null,

    last_name         VARCHAR(255)       not null,
    first_name        VARCHAR(255)       not null,
    middle_names      VARCHAR(255),

    confirmation      boolean            NOT NULL,
    confirmation_code VARCHAR(500),

    global_id         VARCHAR(500),
    created_at        timestamp default current_timestamp,
    update_at         timestamp default current_timestamp,
    deleted_at        timestamp,
    deleted           BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS SPR_ORGANIZATION
(
    id         bigserial    not null
        constraint spr_organization_table_pk primary key,

    name       VARCHAR(255) NOT NULL,

    global_id  VARCHAR(500) NOT NULL,
    created_at timestamp default current_timestamp,
    update_at  timestamp default current_timestamp,
    deleted_at timestamp,
    deleted    BOOLEAN   DEFAULT false,

    UNIQUE (name, global_id)
);

CREATE TABLE IF NOT EXISTS SPR_LOCATION
(
    id         bigserial    not null
        constraint spr_location_table_pk primary key,

    type       VARCHAR(50)  not null,
    name       VARCHAR(255) not null,
    parent     bigint REFERENCES SPR_LOCATION (id),

    global_id  VARCHAR(500) NOT NULL,
    created_at timestamp default current_timestamp,
    update_at  timestamp default current_timestamp,
    deleted_at timestamp,
    deleted    BOOLEAN   DEFAULT false,

    UNIQUE (type, name, global_id)
);

CREATE TABLE IF NOT EXISTS SPR_USERS
(
    id              bigserial    not null
        constraint spr_users_table_pk primary key,

    email           VARCHAR(50)  not null UNIQUE,
    telephone       VARCHAR(50),

    last_name       VARCHAR(255) not null,
    first_name      VARCHAR(255) not null,
    middle_names    VARCHAR(255),

    location_id     bigint REFERENCES SPR_LOCATION (id),
    organization_id bigint REFERENCES SPR_ORGANIZATION (id),

    global_id       VARCHAR(500) NOT NULL,
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS SPR_DEVICE_TYPE
(
    id         bigserial           not null
        constraint spr_device_type_table_pk primary key,

    name       VARCHAR(255) UNIQUE NOT NULL,
    level      VARCHAR(100)        NOT NULL DEFAULT 'Local',

    global_id  VARCHAR(500)        NOT NULL,
    created_at timestamp                    default current_timestamp,
    update_at  timestamp                    default current_timestamp,
    deleted_at timestamp,
    deleted    BOOLEAN                      DEFAULT false
);

CREATE TABLE IF NOT EXISTS SPR_FIRM
(
    id         bigserial           not null
        constraint spr_firm_table_pk primary key,

    name       VARCHAR(255) UNIQUE NOT NULL,
    level      VARCHAR(100)        NOT NULL DEFAULT 'Local',

    global_id  VARCHAR(500)        NOT NULL,
    created_at timestamp                    default current_timestamp,
    update_at  timestamp                    default current_timestamp,
    deleted_at timestamp,
    deleted    BOOLEAN                      DEFAULT false
);

CREATE TABLE IF NOT EXISTS SPR_MODEL
(
    id             bigserial    not null
        constraint spr_model_table_pk primary key,

    name           VARCHAR(255) NOT NULL,
    firm_id        bigint       NOT NULL REFERENCES SPR_FIRM (id),
    device_type_id bigint       NOT NULL REFERENCES SPR_DEVICE_TYPE (id),

    global_id      VARCHAR(500) NOT NULL,
    created_at     timestamp default current_timestamp,
    update_at      timestamp default current_timestamp,
    deleted_at     timestamp,
    deleted        BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS SPR_COUNTERPARTY
(
    id         bigserial    not null
        constraint spr_counterparty_table_pk primary key,

    name       VARCHAR(255) NOT NULL,
    inn        VARCHAR(14),
    telephone  VARCHAR(50),
    email      VARCHAR(100),
    contact    VARCHAR(255),

    global_id  VARCHAR(500) NOT NULL,
    created_at timestamp default current_timestamp,
    update_at  timestamp default current_timestamp,
    deleted_at timestamp,
    deleted    BOOLEAN   DEFAULT false,

    UNIQUE (name, global_id)
);

CREATE TABLE IF NOT EXISTS DOC_INCOME_MAIN
(
    id              bigserial      not null
        constraint doc_income_main_table_pk primary key,

    executed        boolean,
    data_executed   date,

    number_doc      VARCHAR(50)    not null,
    data_doc        date           not null,

    sum_con         numeric(10, 2) not null,
    number_con      VARCHAR(50)    not null,
    data_con        date           not null,

    counterparty_id bigint         not null REFERENCES SPR_COUNTERPARTY (id),
    organization_id bigint REFERENCES SPR_ORGANIZATION (id),

    global_id       VARCHAR(500)   not null,
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS DOC_INCOME_SUB
(
    id         bigserial      not null
        constraint doc_income_sub_table_pk primary key,

    model_id   bigint         not null REFERENCES SPR_MODEL (id),
    count      integer        not null,
    parent_id  bigint REFERENCES DOC_INCOME_SUB (id),
    sum        numeric(10, 2) not null,
    main_id    bigint REFERENCES DOC_INCOME_MAIN (id),

    created_at timestamp default current_timestamp,
    update_at  timestamp default current_timestamp,
    deleted_at timestamp,
    deleted    BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS REGISTRY
(
    id             bigserial    not null
        constraint registry_table_pk primary key,

    model_id       bigint       not null REFERENCES SPR_MODEL (id),
    inv_number     VARCHAR(50),
    location_id    bigint REFERENCES SPR_LOCATION (id),
    user_id    bigint REFERENCES SPR_USERS (id),--сотрудник
--     responsible_id bigint REFERENCES SPR_USERS (id),--материально ответственное лицо
    parent_id      bigint REFERENCES REGISTRY (id),

    global_id      VARCHAR(500) not null,
    created_at     timestamp default current_timestamp,
    update_at      timestamp default current_timestamp
);

CREATE OR REPLACE FUNCTION registry_stamp()
    RETURNS TRIGGER
    LANGUAGE plpgsql
AS $$
BEGIN

        IF OLD.inv_number is null THEN
            IF NEW.inv_number is not null THEN
            INSERT INTO REGISTRY_HISTORY (registry_id, text) VALUES (NEW.id, 'Присвоили инвентарный номер ' || NEW.inv_number);
            END IF;
        END IF;
        IF NEW.inv_number <> OLD.inv_number THEN
            INSERT INTO REGISTRY_HISTORY (registry_id, text) VALUES (NEW.id, 'Изменили инвентарный номер с ' || OLD.inv_number || ' на ' || NEW.inv_number);
        END IF;

    RETURN NEW;
END;
$$;

CREATE TRIGGER registry_stamp BEFORE UPDATE ON registry
    FOR EACH ROW
EXECUTE PROCEDURE registry_stamp();

--
-- CREATE TABLE IF NOT EXISTS DOC_WRITE_OFF_MAIN
-- (
--     id              bigserial not null
--         constraint doc_write_off_main_table_pk primary key,
--
--     executed        boolean,
--     data_executed   date,
--
--     number_doc      VARCHAR(50),
--     data_doc        date,
--
--     organization_id bigint REFERENCES SPR_ORGANIZATION (id),
--     created_at      timestamp default current_timestamp,
--     update_at       timestamp default current_timestamp,
--     deleted_at      timestamp,
--     deleted         BOOLEAN   DEFAULT false
-- );
--
-- CREATE TABLE IF NOT EXISTS DOC_WRITE_OFF_SUB
-- (
--     id              bigserial not null
--         constraint doc_write_off_sub_table_pk primary key,
--
--     registry_id     bigint REFERENCES REGISTRY (id),
--
--     doc_main_id     bigint REFERENCES DOC_WRITE_OFF_MAIN (id),
--
--     organization_id bigint REFERENCES SPR_ORGANIZATION (id),
--     created_at      timestamp default current_timestamp,
--     update_at       timestamp default current_timestamp,
--     deleted_at      timestamp,
--     deleted         BOOLEAN   DEFAULT false
-- );
--
-- CREATE TABLE IF NOT EXISTS DOC_RECYCLE_MAIN
-- (
--     id              bigserial not null
--         constraint doc_recycle_main_table_pk primary key,
--
--     executed        boolean,
--     data_executed   date,
--
--     number_doc      VARCHAR(50),
--     data_doc        date,
--
--     counterparty_id bigint REFERENCES SPR_COUNTERPARTY (id),
--
--     organization_id bigint REFERENCES SPR_ORGANIZATION (id),
--     created_at      timestamp default current_timestamp,
--     update_at       timestamp default current_timestamp,
--     deleted_at      timestamp,
--     deleted         BOOLEAN   DEFAULT false
-- );
--
-- CREATE TABLE IF NOT EXISTS DOC_RECYCLE_SUB
-- (
--     id              bigserial not null
--         constraint doc_recycle_sub_table_pk primary key,
--
--     model_id        bigint REFERENCES SPR_MODEL (id),
--     registry_id     bigint REFERENCES REGISTRY (id),
--     doc_main_id     bigint REFERENCES DOC_RECYCLE_MAIN (id),
--
--     organization_id bigint REFERENCES SPR_ORGANIZATION (id),
--     created_at      timestamp default current_timestamp,
--     update_at       timestamp default current_timestamp,
--     deleted_at      timestamp,
--     deleted         BOOLEAN   DEFAULT false
-- );

CREATE TABLE IF NOT EXISTS REGISTRY_HISTORY
(
    id          bigserial not null
        constraint history_device_table_pk primary key,
    registry_id bigint REFERENCES REGISTRY (id),
    text        VARCHAR(500),
    created_at  timestamp default current_timestamp
);
