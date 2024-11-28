# use AcademicERP;
#
#
# alter table employees add constraint fkdepartment_id foreign key (dep_id) references departments(department_id) on delete set null on update cascade;