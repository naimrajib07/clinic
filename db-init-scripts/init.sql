create schema clinic_data;
create user clinic_user with encrypted password 'pAssw0rd';
grant all privileges on schema clinic_data to clinic_user;
