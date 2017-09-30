select DISTINCT num as ConsecutiveNums FROM
(select num,
	case 
		when @record = num then @count:=@count+1
		when @record <> @record:=num then @count:=1 end as n
    from 
	    Logs ,(select @count:=0,@record:=(SELECT num from Logs limit 0,1)) r
) a
where a.n>=3