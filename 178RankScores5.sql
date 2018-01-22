select a.Score as Score, (select count(*) + 1 from (select distinct Score from Scores) as b where b.Score > a.Score) as Rank
from Scores as a
order by a.Score desc