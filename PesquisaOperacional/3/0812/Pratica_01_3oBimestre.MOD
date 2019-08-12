set TURMAS;
set PROFESSORES;

param ch_turma 				{TURMAS} 				>=0;
param ch_professores 		{PROFESSORES} 			>=0;
param conflito_turma		{TURMAS,TURMAS}			>=0;
param satisfacao_professor	{PROFESSORES,TURMAS}	>=0;

var x = 					{TURMAS,PROFESSORES}	>=0;

maximize satisfacao_total: sum{i in PROFESSORES, j in TURMAS} satisfacao_professor[i,j]*x[j,i];

subject to restricao01		{j in TURMAS}:
	sum{i in PROFESSORES}x[j,i]=1;

subject to restricao02 		{i in PROFESSORES}:
	sum{j in TURMAS}x[j,i]*ch_turma[j] <= ch_professores[i];
	
subject to restricao03		{i in PROFESSORES}:
	sum {j in TURMAS} sum{k in TURMAS} conflito_turma[j,k]*x[j,i]*x[k,i] = 0