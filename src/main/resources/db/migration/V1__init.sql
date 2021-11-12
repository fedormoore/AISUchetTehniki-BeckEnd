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

INSERT INTO accounts (id, email, telephone, password, last_name, first_name, middle_names, confirmation,
                      confirmation_code, global_id, created_at, update_at, deleted_at, deleted)
VALUES (1, 'fedormoore@gmail.com', null, '$2a$10$xESQxv14VynUaoeLAiR8Me5jDvZPmovBJ8Y1fvhNis3G5.ywczzj6', 'Мур', 'Федор',
        null, true, '914578cc-c17b-465f-8cd9-b91b6ca98ad7', '08e85e94-a327-4b53-846c-ee936d9f20b5',
        '2021-11-09 17:40:24.721423', '2021-11-09 17:40:24.721423', null, false);

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

INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (1, 'country', 'Россия', null, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:16:39.041078',
        '2021-11-11 10:16:39.041078', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (2, 'subject', 'ЯНАО', 1, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:16:47.428691',
        '2021-11-11 10:16:47.428691', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (3, 'city', 'Салехард', 2, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:16:55.928351',
        '2021-11-11 10:16:55.928351', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (4, 'address', 'Свердлова 48', 3, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:17:05.792857',
        '2021-11-11 10:17:05.792857', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (5, 'floor', '3', 4, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:17:11.055051',
        '2021-11-11 10:17:11.055051', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (6, 'cabinet', '301', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:17:16.627124',
        '2021-11-11 10:17:16.627124', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (7, 'cabinet', '302', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:08.050814',
        '2021-11-11 10:18:08.050814', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (8, 'cabinet', '303', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:10.987896',
        '2021-11-11 10:18:10.987896', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (9, 'cabinet', '304', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:13.882631',
        '2021-11-11 10:18:13.882631', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (10, 'cabinet', '305', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:16.320132',
        '2021-11-11 10:18:16.320132', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (11, 'cabinet', '306', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:19.337204',
        '2021-11-11 10:18:19.337204', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (12, 'cabinet', '307', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:22.874502',
        '2021-11-11 10:18:22.874502', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (13, 'cabinet', '308', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:26.559129',
        '2021-11-11 10:18:26.559129', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (14, 'cabinet', '309', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:28.968077',
        '2021-11-11 10:18:28.968077', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (15, 'cabinet', '310', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:31.411312',
        '2021-11-11 10:18:31.411312', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (16, 'cabinet', '311', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:34.149064',
        '2021-11-11 10:18:34.149064', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (17, 'cabinet', '312', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:37.955751',
        '2021-11-11 10:18:37.955751', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (18, 'cabinet', '313', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:40.524324',
        '2021-11-11 10:18:40.524324', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (19, 'cabinet', '314', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:43.811281',
        '2021-11-11 10:18:43.811281', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (20, 'cabinet', '315', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:46.177641',
        '2021-11-11 10:18:46.177641', null, false);
INSERT INTO public.spr_location (id, type, name, parent, global_id, created_at, update_at, deleted_at, deleted)
VALUES (21, 'cabinet', '316', 5, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:18:48.649399',
        '2021-11-11 10:18:48.649399', null, false);

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

INSERT INTO public.spr_users (id, email, telephone, last_name, first_name, middle_names, location_id, organization_id,
                              global_id, created_at, update_at, deleted_at, deleted)
VALUES (1, 'ufimceva@slh.yanao.ru', null, 'Уфимцева', 'Елена', 'Викторовна', 11, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:21:33.875965', '2021-11-11 10:21:33.875965', null,
        false);
INSERT INTO public.spr_users (id, email, telephone, last_name, first_name, middle_names, location_id, organization_id,
                              global_id, created_at, update_at, deleted_at, deleted)
VALUES (2, 'iluhina@slh.yanao.ru', null, 'Илюхина', 'Светлана', 'Валерьевна', 14, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:22:08.433840', '2021-11-11 10:22:08.433840', null,
        false);
INSERT INTO public.spr_users (id, email, telephone, last_name, first_name, middle_names, location_id, organization_id,
                              global_id, created_at, update_at, deleted_at, deleted)
VALUES (3, 'stepanova@slh.yanao.ru', null, 'Степанова', 'Любовь', 'Анатольевна', 10, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:23:02.989056', '2021-11-11 10:23:02.989056', null,
        false);
INSERT INTO public.spr_users (id, email, telephone, last_name, first_name, middle_names, location_id, organization_id,
                              global_id, created_at, update_at, deleted_at, deleted)
VALUES (5, 'kugaevskaya@slh.yanao.ru', null, 'Кугаевская', 'Наталия', 'Петровна', 11, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:24:14.303568', '2021-11-11 10:24:14.303568', null,
        false);
INSERT INTO public.spr_users (id, email, telephone, last_name, first_name, middle_names, location_id, organization_id,
                              global_id, created_at, update_at, deleted_at, deleted)
VALUES (6, 'komarova@slh.yanao.ru', null, 'Комарова', 'Алия', 'Рашитовна', 11, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:24:44.550937', '2021-11-11 10:24:44.550937', null,
        false);
INSERT INTO public.spr_users (id, email, telephone, last_name, first_name, middle_names, location_id, organization_id,
                              global_id, created_at, update_at, deleted_at, deleted)
VALUES (4, 'filippovaea@slh.yanao.ru', null, 'Филиппова', 'Елена', 'Александровна', 10, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:23:36.437841', '2021-11-11 10:25:00.015070', null,
        false);


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

insert into spr_device_type(name, level, global_id)
values ('Компьютер в сборе', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Монитор', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Системный блок', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Материнская плата', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Процессор', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Видеокарта', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Кулер', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('HDD', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('SSD', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('CD-ROM', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('DVD-ROM', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Оперативная память', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Принтер', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Картридж', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Сканер', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Клавиатура', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Беспроводная клавиатура', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Блок питания', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Источник бесперебойного питания', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Колонки', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Мышь', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');
insert into spr_device_type(name, level, global_id)
values ('Беспроводная мышь', 'Global', '08e85e94-a327-4b53-846c-ee936d9f20b5');

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

insert into spr_firm(name, level, global_id)
values ('HP', 'Global', 'Global');
insert into spr_firm(name, level, global_id)
values ('Defender', 'Global', 'Global');
insert into spr_firm(name, level, global_id)
values ('iiyama', 'Global', 'Global');
insert into spr_firm(name, level, global_id)
values ('Samsung', 'Global', 'Global');
insert into spr_firm(name, level, global_id)
values ('Asus', 'Global', 'Global');

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

INSERT INTO public.spr_counterparty (id, name, inn, telephone, email, contact, global_id, created_at, update_at,
                                     deleted_at, deleted)
VALUES (1, 'ООО "Рога и Копыта"', null, null, null, null, '08e85e94-a327-4b53-846c-ee936d9f20b5',
        '2021-11-11 10:13:09.247807', '2021-11-11 10:13:09.247807', null, false);
INSERT INTO public.spr_counterparty (id, name, inn, telephone, email, contact, global_id, created_at, update_at,
                                     deleted_at, deleted)
VALUES (2, 'ООО "Вася и Петя"', null, null, null, null, '08e85e94-a327-4b53-846c-ee936d9f20b5',
        '2021-11-11 10:13:18.429371', '2021-11-11 10:13:18.429371', null, false);
INSERT INTO public.spr_counterparty (id, name, inn, telephone, email, contact, global_id, created_at, update_at,
                                     deleted_at, deleted)
VALUES (3, 'ООО "Первая утилизирущая"', null, null, null, null, '08e85e94-a327-4b53-846c-ee936d9f20b5',
        '2021-11-11 10:13:43.492513', '2021-11-11 10:13:43.492513', null, false);
INSERT INTO public.spr_counterparty (id, name, inn, telephone, email, contact, global_id, created_at, update_at,
                                     deleted_at, deleted)
VALUES (4, 'ДФ', null, null, null, null, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:13:51.262047',
        '2021-11-11 10:13:51.262047', null, false);
INSERT INTO public.spr_counterparty (id, name, inn, telephone, email, contact, global_id, created_at, update_at,
                                     deleted_at, deleted)
VALUES (5, 'ООО "Мегабит"', null, null, null, null, '08e85e94-a327-4b53-846c-ee936d9f20b5',
        '2021-11-11 10:14:11.038546', '2021-11-11 10:14:11.038546', null, false);
INSERT INTO public.spr_counterparty (id, name, inn, telephone, email, contact, global_id, created_at, update_at,
                                     deleted_at, deleted)
VALUES (6, 'ИП Слинкин', null, null, null, null, '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-11 10:14:22.558355',
        '2021-11-11 10:14:22.558355', null, false);

CREATE TABLE IF NOT EXISTS DOC_INCOME_MAIN
(
    id              bigserial    not null
        constraint doc_income_main_table_pk primary key,

    executed        boolean,
    data_executed   date,

    number_doc      VARCHAR(50)  not null,
    data_doc        date         not null,

    sum_con         money,
    number_con      VARCHAR(50),
    data_con        date,

    counterparty_id bigint       not null REFERENCES SPR_COUNTERPARTY (id),
    organization_id bigint REFERENCES SPR_ORGANIZATION (id),

    global_id       VARCHAR(500) NOT NULL,
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp,
    deleted_at      timestamp,
    deleted         BOOLEAN   DEFAULT false
);

INSERT INTO public.doc_income_main (id, executed, data_executed, number_doc, data_doc, sum_con, number_con, data_con,
                                    counterparty_id, organization_id, global_id, created_at, update_at, deleted_at,
                                    deleted)
VALUES (1, true, '2021-11-08', '1', '2021-11-08', '1 000,00 ?', '01', '2021-11-01', 1, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-12 03:38:49.638153', '2021-11-12 03:38:49.638153', null,
        false);
INSERT INTO public.doc_income_main (id, executed, data_executed, number_doc, data_doc, sum_con, number_con, data_con,
                                    counterparty_id, organization_id, global_id, created_at, update_at, deleted_at,
                                    deleted)
VALUES (2, false, null, '2', '2021-11-08', '1 100,00 ?', '02', '2021-11-02', 2, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-12 03:38:49.638153', '2021-11-12 03:38:49.638153', null,
        false);
INSERT INTO public.doc_income_main (id, executed, data_executed, number_doc, data_doc, sum_con, number_con, data_con,
                                    counterparty_id, organization_id, global_id, created_at, update_at, deleted_at,
                                    deleted)
VALUES (3, false, null, '3', '2021-11-09', '1 200,00 ?', '03', '2021-11-03', 3, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-12 03:38:49.638153', '2021-11-12 03:38:49.638153', null,
        false);
INSERT INTO public.doc_income_main (id, executed, data_executed, number_doc, data_doc, sum_con, number_con, data_con,
                                    counterparty_id, organization_id, global_id, created_at, update_at, deleted_at,
                                    deleted)
VALUES (4, false, null, '4', '2021-11-09', '1 300,00 ?', '04', '2021-11-04', 4, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-12 03:38:49.638153', '2021-11-12 03:38:49.638153', null,
        false);
INSERT INTO public.doc_income_main (id, executed, data_executed, number_doc, data_doc, sum_con, number_con, data_con,
                                    counterparty_id, organization_id, global_id, created_at, update_at, deleted_at,
                                    deleted)
VALUES (5, false, null, '5', '2021-11-10', '1 400,00 ?', '05', '2021-11-05', 5, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-12 03:38:49.638153', '2021-11-12 03:38:49.638153', null,
        false);
INSERT INTO public.doc_income_main (id, executed, data_executed, number_doc, data_doc, sum_con, number_con, data_con,
                                    counterparty_id, organization_id, global_id, created_at, update_at, deleted_at,
                                    deleted)
VALUES (6, true, '2021-11-10', '6', '2021-11-10', '1 500,00 ?', '06', '2021-11-08', 1, null,
        '08e85e94-a327-4b53-846c-ee936d9f20b5', '2021-11-12 03:38:49.638153', '2021-11-12 03:38:49.638153', null,
        false);

-- CREATE TABLE IF NOT EXISTS DOC_INCOME_SUB
-- (
--     id              bigserial not null
--         constraint doc_income_sub_table_pk primary key,
--
--     model_id        bigint REFERENCES SPR_MODEL (id),
--     count           integer,
--     parent          integer,
-- sum         money,
--     doc_main_id     bigint REFERENCES DOC_INCOME_MAIN (id),
--
--     created_at      timestamp default current_timestamp,
--     update_at       timestamp default current_timestamp,
--     deleted_at      timestamp,
--     deleted         BOOLEAN   DEFAULT false
-- );
--
-- insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id)
-- values (3, 2, null, 1);
-- insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id)
-- values (2, 2, 1, 1);
-- insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id)
-- values (1, 2, null, 1);
-- insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id)
-- values (3, 1, 3, 1);
-- insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id)
-- values (5, 2, 4, 1);
-- insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id)
-- values (4, 2, 4, 1);
-- insert into DOC_INCOME_SUB(model_id, count, parent, doc_main_id)
-- values (2, 2, 3, 1);
--
-- CREATE TABLE IF NOT EXISTS REGISTRY
-- (
--     id              bigserial not null
--         constraint registry_table_pk primary key,
--
--     model_id        bigint REFERENCES SPR_MODEL (id),
--     inv_number      integer,
--     location_id     bigint REFERENCES SPR_LOCATION (id),
--     employee_id     bigint REFERENCES SPR_USERS (id),--сотрудник
--     responsible_id  bigint REFERENCES SPR_USERS (id),--материально ответственное лицо
--     reserve         integer,
--     status          VARCHAR(50),
--     parent          integer,
--
--     organization_id bigint REFERENCES SPR_ORGANIZATION (id),
--     created_at      timestamp default current_timestamp,
--     update_at       timestamp default current_timestamp,
--     deleted_at      timestamp,
--     deleted         BOOLEAN   DEFAULT false
-- );
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
--
-- CREATE TABLE IF NOT EXISTS HISTORY_DEVICE
-- (
--     id          bigserial not null
--         constraint history_device_table_pk primary key,
--
--     registry_id bigint REFERENCES REGISTRY (id),
--
--     text        VARCHAR(255),
--
--     created_at  timestamp default current_timestamp
-- );
