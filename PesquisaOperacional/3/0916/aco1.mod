set Produtos
param velocidade {Produtos} >0		# Toneladas produzidas por hora
param disponibilidade >= 0;			# Horas disponíveis por semana
param Lucro {Produtos}				# Lucro unitário por tonelada
param Limites {Produtos}			# Limites de produção nos produtos

#Definindo as variáveis

var quantidade {p in Produtos} >= 0, <= Limites[p];

maximize Lucro_total: sum {p in produtos} Lucro[p]*quantidade[p];

subject to Tempo: sum {p in Produtos} (1/velocidade[p] * quantidade[p] <= disponibilidade;