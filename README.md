 # 📱 TechWeekMobile

## Aplicativo Android desenvolvido para auxiliar na organização da Tech Week, permitindo o gerenciamento de participantes, palestras, palestrantes, projetos e o registro de check-ins durante o evento.

##  Funcionalidades <br>
 * Cadastro de participantes <br>
 * Validação de RA, nome e e-mail <br>
 * Check-in por RA usando banco local <br>
 * Persistência com Room <br>
 * Cadastro e listagem de palestras <br>
 * Cadastro de palestrantes <br> 
 * Registro de projetos vinculados a participantes <br>
 * Prevenção de check-ins duplicados <br>
 * Interface simples e funcional <br>


#  Telas Principais

### CadastroActivity <br>
Formulário de nome, RA e e-mail <br>
Validação em tempo real <br>
Inserção no banco Room <br>


### CheckInActivity <br>
Campo de RA <br>
Botão para registrar presença <br>
Exibição de mensagem caso já tenha check-in <br>


# 🏛️ Arquitetura do Projeto

## O app segue uma estrutura baseada em:

Room ORM (persistência) <br>
Activities (interface) <br>
Utilidades (validação, controle de check-ins) <br>
Threading com ExecutorService (operações no banco) <br>

app/ <br>
 ├─ java/ <br>
 │   ├─ model/          → Entidades Room <br>
 │   ├─ dao/            → DAOs do Room <br>
 │   ├─ database/       → AppDatabase <br> 
 │   ├─ manager/        → Regras de negócio (CheckInManager) <br>
 │   ├─ ui/             → Activities da interface <br> 
 │   └─ utils/          → Validações e funções auxiliares <br>
 └─ res/ <br>
     ├─ layout/         → XML de telas <br>
     └─ values/         → Temas, cores e strings <br>


# 🗄️ Banco de Dados  
## Entidades:
### Entidade - Descrição
Participant -	Representa um participante do evento <br>
Speaker -	Palestrante da TechWeek <br>
Talk -	Palestra realizada <br>
Project -	Projeto cadastrado por um participante <br>
CheckIn -	Registro de presença (check-in dos participantes) <br>


# 📌 Conclusão

 ### O TechWeek Mobile foi desenvolvido com foco em organização e eficiência no gerenciamento de eventos acadêmicos.
 ### Utilizando o Room para persistência local e uma arquitetura modular baseada em DAOs, Managers e UI.
 ### O projeto oferece uma base sólida para evolução e novas funcionalidades.

 ### Ele pode servir tanto como uma solução prática para eventos reais quanto como um ótimo estudo de caso para quem deseja aprender Android nativo com boas práticas.
