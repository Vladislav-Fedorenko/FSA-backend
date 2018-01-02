-- DEVICES

CREATE TABLE devices (
  id bigserial PRIMARY KEY,
  name varchar,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ
);

INSERT INTO devices (name, created_at) VALUES
  ('ГВ санузел', CURRENT_TIMESTAMP),
  ('ХВ санузел', CURRENT_TIMESTAMP),
  ('ГВ кухня', CURRENT_TIMESTAMP),
  ('ХВ кухня', CURRENT_TIMESTAMP),
  ('Электроэнергия', CURRENT_TIMESTAMP);

CREATE TABLE archive_devices (
  id bigserial PRIMARY KEY,
  devices_id bigserial,
  name varchar,
  created_at TIMESTAMPTZ NOT NULL,
  archiving_reason varchar NOT NULL
);

-- HOME INFO

CREATE TABLE home_info (
  id bigserial PRIMARY KEY,
  name varchar,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ
);

CREATE TABLE archive_home_info (
  id bigserial PRIMARY KEY,
  home_info_id bigserial,
  name varchar,
  created_at TIMESTAMPTZ NOT NULL,
  archiving_reason varchar NOT NULL
);

-- HOME DEVICES

CREATE TABLE home_devices (
  id bigserial PRIMARY KEY,
  devices_id bigserial REFERENCES devices (id),
  home_info_id bigserial REFERENCES home_info (id),
  number varchar,
  verification_date DATE,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ
);

CREATE TABLE archive_home_devices (
  id bigserial PRIMARY KEY,
  home_devices_id bigserial,
  devices_id bigserial,
  home_info_id bigserial,
  number varchar,
  verification_date DATE,
  created_at TIMESTAMPTZ NOT NULL,
  archiving_reason varchar NOT NULL
);

-- DEVICES VALUES

CREATE TABLE devices_values (
  id bigserial PRIMARY KEY,
  home_devices_id bigserial REFERENCES devices,
  value INTEGER,
  date DATE,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ
);

CREATE TABLE archive_devices_values (
  id bigserial PRIMARY KEY,
  devices_values_id bigserial,
  value INTEGER,
  date DATE,
  created_at TIMESTAMPTZ NOT NULL,
  archiving_reason varchar NOT NULL
);