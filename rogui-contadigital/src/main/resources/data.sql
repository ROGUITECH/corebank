insert into dados_conta values (
	'453221', 
	'88', 
	'21133312356', 
	2, 
	to_date(' 14-mar-2019 16:00 ',' dd-MON-yyyy hh24:mi'), 
	to_date(' 21-jan-2021 16:00 ',' dd-MON-yyyy hh24:mi'), 
	'9632695', 
	'ATIVO');

insert into dados_conta values (
	'654321', 
	'88', 
	'22233311123', 
	1, 
	to_date(' 14-mar-2019 16:00 ',' dd-MON-yyyy hh24:mi'), 
	to_date(' 21-jan-2021 16:00 ',' dd-MON-yyyy hh24:mi'), 
	'9632695', 
	'ATIVO');
	
	insert into public.cadastro_principal values (
       1,
       to_date ('14-02-1980', 'dd-mm-yyyy'),
	'Osmar@gmail.com', 
	'Osmar',
	'PF', 
	'453221'
	);
	
	insert into public.cadastro_principal values (
       2,
       to_date ('14-02-1979', 'dd-mm-yyyy'),
	'marta@gmail.com', 
	'Marta',
	'PF', 
	'654321'
	);