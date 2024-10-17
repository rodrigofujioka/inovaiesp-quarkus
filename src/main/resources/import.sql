-- Inserindo dados na tabela Product
insert into product (id, name, price, manufactureDate, expirationDate, productType_id)
values (1, 'Laptop', 1200.00, '2023-01-01', null, 1);

insert into product (id, name, price, manufactureDate, expirationDate, productType_id)
values (2, 'Smartphone', 800.00, '2023-02-01', null, 1);

insert into product (id, name, price, manufactureDate, expirationDate, productType_id)
values (3, 'T-shirt', 25.00, '2023-03-01', null, 3);

-- Inserindo dados na tabela ProductType
insert into producttype (id, typeName)
values (1, 'ELECTRONICS');

insert into producttype (id, typeName)
values (2, 'PERISHABLE');

insert into producttype (id, typeName)
values (3, 'CLOTHING');

-- Alterando a sequência de ID da tabela Product para continuar a partir do próximo valor
alter sequence product_seq restart with 4;

-- Inserindo dados na tabela Student
insert into student (id, name, email, birthDate)
values (1, 'John Doe', 'john.doe@example.com', '2000-01-01');

insert into student (id, name, email, birthDate)
values (2, 'Jane Smith', 'jane.smith@example.com', '1998-05-15');

insert into student (id, name, email, birthDate)
values (3, 'Alice Johnson', 'alice.johnson@example.com', '1995-10-10');

-- Alterando a sequência de ID da tabela Student para continuar a partir do próximo valor
alter sequence student_seq restart with 4;
