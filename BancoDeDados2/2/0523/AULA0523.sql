select nm_func, nm_sobrenome, dt_nasc from func
where regexp_like(to_char(dt_nasc,'yyyy'),'^197[0-5]$');

select nm_func, nm_sobrenome, dt_nasc from func