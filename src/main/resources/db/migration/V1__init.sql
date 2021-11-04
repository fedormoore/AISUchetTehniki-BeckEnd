CREATE TABLE IF NOT EXISTS SPR_ORGANIZATION
(
    id         bigserial           not null
        constraint spr_organization_table_pk primary key,

    name       VARCHAR(255) UNIQUE NOT NULL,

    created_at timestamp default current_timestamp,
    update_at  timestamp default current_timestamp,
    deleted_at timestamp,
    deleted    BOOLEAN   DEFAULT false
);

insert into SPR_ORGANIZATION(name)
values ('тест1');
insert into SPR_ORGANIZATION(name)
values ('тест2');

CREATE TABLE IF NOT EXISTS SPR_LOCATION
(
    id              bigserial    not null
        constraint spr_location_table_pk primary key,

    type            VARCHAR(50)  not null,
    name            VARCHAR(255) not null,
    parent          bigint REFERENCES SPR_LOCATION (id),

    organization_id bigint       not null REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false,

    UNIQUE (type, name, organization_id)
);

CREATE TABLE IF NOT EXISTS SPR_USERS
(
    id                bigserial not null
        constraint spr_users_table_pk primary key,

    email             VARCHAR(50) UNIQUE,
    telephone         VARCHAR(50),
    password          VARCHAR(500),

    last_name         VARCHAR(255),
    first_name        VARCHAR(255),
    middle_names      VARCHAR(255),

    location_id       bigint REFERENCES SPR_LOCATION (id),

    confirmation      boolean   NOT NULL,
    confirmation_code VARCHAR(500),

    organization_id   bigint REFERENCES SPR_ORGANIZATION (id),
    created_at        timestamp default current_timestamp,
    update_at         timestamp default current_timestamp,
    deleted_at        timestamp,
    deleted           BOOLEAN   DEFAULT false
);

insert into spr_users(email, password, confirmation, organization_id)
values ('fedormoore@gmail.com', '$2a$10$/yKSiX76JO0QBRHHYOxfpelED./.gpfla6uMfXpGkotQXOsRU9kbm', TRUE,
        1);
insert into spr_users(email, password, confirmation, organization_id)
values ('fedormoore089@ya.ru', '$2a$10$/yKSiX76JO0QBRHHYOxfpelED./.gpfla6uMfXpGkotQXOsRU9kbm', TRUE,
        2);

CREATE TABLE IF NOT EXISTS SPR_DEVICE_TYPE
(
    id              bigserial           not null
        constraint spr_device_type_table_pk primary key,

    name            VARCHAR(255) UNIQUE NOT NULL,
    level           VARCHAR(100)        NOT NULL DEFAULT 'Local',

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp                    default current_timestamp,
    update_at       timestamp                    default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN                      DEFAULT false
);

insert into spr_device_type(name, level)
values ('Компьютер в сборе', 'Global');
insert into spr_device_type(name, level)
values ('Монитор', 'Global');
insert into spr_device_type(name, level)
values ('Системный блок', 'Global');
insert into spr_device_type(name, level)
values ('Материнская плата', 'Global');
insert into spr_device_type(name, level)
values ('Процессор', 'Global');
insert into spr_device_type(name, level)
values ('Видеокарта', 'Global');
insert into spr_device_type(name, level)
values ('Кулер', 'Global');
insert into spr_device_type(name, level)
values ('HDD', 'Global');
insert into spr_device_type(name, level)
values ('SSD', 'Global');
insert into spr_device_type(name, level)
values ('CD-ROM', 'Global');
insert into spr_device_type(name, level)
values ('DVD-ROM', 'Global');
insert into spr_device_type(name, level)
values ('Оперативная память', 'Global');
insert into spr_device_type(name, level)
values ('Принтер', 'Global');
insert into spr_device_type(name, level)
values ('Картридж', 'Global');
insert into spr_device_type(name, level)
values ('Сканер', 'Global');
insert into spr_device_type(name, level)
values ('Клавиатура', 'Global');
insert into spr_device_type(name, level)
values ('Беспроводная клавиатура', 'Global');
insert into spr_device_type(name, level)
values ('Блок питания', 'Global');
insert into spr_device_type(name, level)
values ('Источник бесперебойного питания', 'Global');
insert into spr_device_type(name, level)
values ('Колонки', 'Global');
insert into spr_device_type(name, level)
values ('Мышь', 'Global');
insert into spr_device_type(name, level)
values ('Беспроводная мышь', 'Global');

CREATE TABLE IF NOT EXISTS SPR_FIRM
(
    id              bigserial           not null
        constraint spr_firm_table_pk primary key,

    name            VARCHAR(255) UNIQUE NOT NULL,
    level           VARCHAR(100)        NOT NULL DEFAULT 'Local',

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

insert into spr_firm(name, level)
values ('HP', 'Global');
insert into spr_firm(name, level)
values ('Defender', 'Global');
insert into spr_firm(name, level)
values ('iiyama', 'Global');
insert into spr_firm(name, level)
values ('Samsung', 'Global');
insert into spr_firm(name, level)
values ('Asus', 'Global');

CREATE TABLE IF NOT EXISTS SPR_MODEL
(
    id              bigserial           not null
        constraint spr_model_table_pk primary key,

    name            VARCHAR(255) NOT NULL,
    firm_id         bigint REFERENCES SPR_FIRM (id),
    device_type_id  bigint REFERENCES SPR_DEVICE_TYPE (id),

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

insert into spr_model(name, firm_id, device_type_id, organization_id)
values ('Компьютер в сборе HP', 1, 1, 1);
insert into spr_model(name, firm_id, device_type_id, organization_id)
values ('Монитор HP', 1, 1, 1);
insert into spr_model(name, firm_id, device_type_id, organization_id)
values ('Системный блок HP', 1, 1, 1);
insert into spr_model(name, firm_id, device_type_id, organization_id)
values ('HDD HP', 1, 1, 1);
insert into spr_model(name, firm_id, device_type_id, organization_id)
values ('SSD HP', 1, 1, 1);

CREATE TABLE IF NOT EXISTS SPR_COUNTERPARTY
(
    id              bigserial           not null
        constraint spr_counterparty_table_pk primary key,

    name            VARCHAR(255) NOT NULL,
    inn             VARCHAR(14),
    telephone       VARCHAR(50),
    email            VARCHAR(100),
    contact         VARCHAR(255),

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

insert into SPR_COUNTERPARTY(name, organization_id)
values ('ООО "Рога и Копыта"', 1);

CREATE TABLE IF NOT EXISTS DOC_INCOME_MAIN
(
    id              bigserial not null
        constraint doc_income_main_table_pk primary key,

    executed        boolean,
    data_executed   date,

    number_doc      VARCHAR(50),
    data_doc        date,

    counterparty_id bigint REFERENCES SPR_COUNTERPARTY (id),

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

insert into DOC_INCOME_MAIN(executed, counterparty_id, organization_id)
values (false, 1, 1);

CREATE TABLE IF NOT EXISTS DOC_INCOME_SUB
(
    id              bigserial not null
        constraint doc_income_sub_table_pk primary key,

    model_id        bigint REFERENCES SPR_MODEL (id),
    count           integer,
    parent          integer,
    doc_main_id     bigint REFERENCES DOC_INCOME_MAIN (id),

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id, organization_id)
values (3, 2, null, 1, 1);
insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id, organization_id)
values (2, 2, 1, 1, 1);
insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id, organization_id)
values (1, 2, null, 1, 1);
insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id, organization_id)
values (3, 1, 3, 1, 1);
insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id, organization_id)
values (5, 2, 4, 1, 1);
insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id, organization_id)
values (4, 2, 4, 1, 1);
insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id, organization_id)
values (2, 2, 3, 1, 1);

CREATE TABLE IF NOT EXISTS REGISTRY
(
    id              bigserial not null
        constraint registry_table_pk primary key,

    model_id        bigint REFERENCES SPR_MODEL (id),
    inv_number      integer,
    location_id     bigint REFERENCES SPR_LOCATION (id),
    employee_id     bigint REFERENCES SPR_USERS (id),--сотрудник
    responsible_id  bigint REFERENCES SPR_USERS (id),--материально ответственное лицо
    reserve         integer,
    status          VARCHAR(50),
    parent          integer,

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS DOC_WRITE_OFF_MAIN
(
    id              bigserial not null
        constraint doc_write_off_main_table_pk primary key,

    executed        boolean,
    data_executed   date,

    number_doc      VARCHAR(50),
    data_doc        date,

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS DOC_WRITE_OFF_SUB
(
    id              bigserial not null
        constraint doc_write_off_sub_table_pk primary key,

    registry_id     bigint REFERENCES REGISTRY (id),

    doc_main_id     bigint REFERENCES DOC_WRITE_OFF_MAIN (id),

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS DOC_RECYCLE_MAIN
(
    id              bigserial not null
        constraint doc_recycle_main_table_pk primary key,

    executed        boolean,
    data_executed   date,

    number_doc      VARCHAR(50),
    data_doc        date,

    counterparty_id bigint REFERENCES SPR_COUNTERPARTY (id),

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS DOC_RECYCLE_SUB
(
    id              bigserial not null
        constraint doc_recycle_sub_table_pk primary key,

    model_id        bigint REFERENCES SPR_MODEL (id),
    registry_id     bigint REFERENCES REGISTRY (id),
    doc_main_id     bigint REFERENCES DOC_RECYCLE_MAIN (id),

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS HISTORY_DEVICE
(
    id          bigserial not null
        constraint history_device_table_pk primary key,

    registry_id bigint REFERENCES REGISTRY (id),

    text        VARCHAR(255),

    created_at  timestamp default current_timestamp
);
