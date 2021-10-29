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
values ('Департамент финансов Администрации города Салехарда');

CREATE TABLE IF NOT EXISTS SPR_LOCATION
(
    id              bigserial           not null
        constraint spr_location_table_pk primary key,

    type            VARCHAR(50)         NOT NULL,
    name            VARCHAR(255) UNIQUE NOT NULL,
    parent          bigint REFERENCES SPR_LOCATION (id),

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

CREATE TABLE IF NOT EXISTS SPR_USERS
(
    id                bigserial    not null
        constraint spr_users_table_pk primary key,

    email             VARCHAR(50) UNIQUE,
    telephone         VARCHAR(50),
    password          VARCHAR(500),

    last_name         VARCHAR(255),
    first_name        VARCHAR(255),
    middle_names VARCHAR(255),

    location_id       bigint REFERENCES SPR_LOCATION (id),

    confirmation      boolean      NOT NULL,
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

CREATE TABLE IF NOT EXISTS SPR_DEVICE_TYPE
(
    id              bigserial           not null
        constraint spr_device_type_table_pk primary key,

    name            VARCHAR(255) UNIQUE NOT NULL,

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

insert into spr_device_type(name, organization_id)
values ('Компьютер в сборе', 1);
insert into spr_device_type(name, organization_id)
values ('Монитор', 1);
insert into spr_device_type(name, organization_id)
values ('Системный блок', 1);
insert into spr_device_type(name, organization_id)
values ('Материнская плата', 1);
insert into spr_device_type(name, organization_id)
values ('Процессор', 1);
insert into spr_device_type(name, organization_id)
values ('Видеокарта', 1);
insert into spr_device_type(name, organization_id)
values ('Кулер', 1);
insert into spr_device_type(name, organization_id)
values ('HDD', 1);
insert into spr_device_type(name, organization_id)
values ('SSD', 1);
insert into spr_device_type(name, organization_id)
values ('CD-ROM', 1);
insert into spr_device_type(name, organization_id)
values ('DVD-ROM', 1);
insert into spr_device_type(name, organization_id)
values ('Оперативная память', 1);
insert into spr_device_type(name, organization_id)
values ('Принтер', 1);
insert into spr_device_type(name, organization_id)
values ('Картридж', 1);
insert into spr_device_type(name, organization_id)
values ('Сканер', 1);
insert into spr_device_type(name, organization_id)
values ('Клавиатура', 1);
insert into spr_device_type(name, organization_id)
values ('Беспроводная клавиатура', 1);
insert into spr_device_type(name, organization_id)
values ('Блок питания', 1);
insert into spr_device_type(name, organization_id)
values ('Источник бесперебойного питания', 1);
insert into spr_device_type(name, organization_id)
values ('Колонки', 1);
insert into spr_device_type(name, organization_id)
values ('Мышь', 1);
insert into spr_device_type(name, organization_id)
values ('Беспроводная мышь', 1);

CREATE TABLE IF NOT EXISTS SPR_FIRM
(
    id              bigserial           not null
        constraint spr_firm_table_pk primary key,

    name            VARCHAR(255) UNIQUE NOT NULL,

    organization_id bigint REFERENCES SPR_ORGANIZATION (id),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

insert into spr_firm(name, organization_id)
values ('HP', 1);
insert into spr_firm(name, organization_id)
values ('Defender', 1);
insert into spr_firm(name, organization_id)
values ('iiyama', 1);
insert into spr_firm(name, organization_id)
values ('Samsung', 1);
insert into spr_firm(name, organization_id)
values ('Asus', 1);

CREATE TABLE IF NOT EXISTS SPR_MODEL
(
    id              bigserial           not null
        constraint spr_model_table_pk primary key,

    name            VARCHAR(255) UNIQUE NOT NULL,
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

    name            VARCHAR(255) UNIQUE NOT NULL,
    inn             integer,
    telephone       VARCHAR(50),
    mail            VARCHAR(50),
    contact         VARCHAR(50),

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
    employee_id        bigint REFERENCES SPR_USERS (id),--сотрудник
    responsible_id        bigint REFERENCES SPR_USERS (id),--материально ответственное лицо
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
