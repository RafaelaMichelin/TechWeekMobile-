 # 📱 TechWeekMobile

Aplicativo Android desenvolvido para auxiliar na organização da Tech Week. O projeto foca em uma experiência offline-first, permitindo que participantes se cadastrem, consultem a programação e confirmem presença em atividades.

##  Funcionalidades
 Para Participantes:
 * Programação do Evento: Visualização das palestras com horários e locais. <br>
 * Cadastro de participantes:  Registro completo com Nome, RA, Curso (ADS ou Engenharia de Software) e Semestre. <br>
 * Opção de Coffee Break: Escolha de participação no momento do cadastro <br>
 * Registro de projetos vinculados a participantes <br>
 * Validação de RA, nome e e-mail <br>
 * Check-in por RA usando banco local: Botão de "Participar" para confirmar presença em eventos específicos.<br>
 * Localização: Atalho direto para o Google Maps com o local do evento. <br>
 
 Para administradores:
* Área Protegida: Acesso restrito via chave de segurança.
* Gestão de Coffee Break: Lista exclusiva de todos os participantes que optaram pelo coffee break, facilitando a logística do evento.

#  Telas Principais

### Inicial
<img width="350" height="800" alt="Screenshot_20260509_150721" src="https://github.com/user-attachments/assets/c102016b-efa4-4a68-a192-d1d42bdb2fd2" />

### Cadastro <br>
<img width="350" height="800" alt="Screenshot_20260509_151019" src="https://github.com/user-attachments/assets/07977895-cb68-459e-a19f-73b012fa32dd" />

### Programação
<img width="350" height="800" alt="Screenshot_20260509_151042" src="https://github.com/user-attachments/assets/b78d7dd4-8433-4506-bf4f-a1add8853685" />

### Acesso a Administrador 
<img width="350" height="800" alt="Screenshot_20260509_151141" src="https://github.com/user-attachments/assets/52811208-4561-41a2-9ea7-fe8560fa1f64" />

### Administrador
<img width="350" height="800" alt="Screenshot_20260509_151210" src="https://github.com/user-attachments/assets/0e8aca87-8ebf-4787-b74c-e65453d24a5c" />


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
 │   ├─ ui/             → Activities da interface, Regras de negócio e validações<br> 
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

O TechWeek Mobile foi desenvolvido com foco em organização e eficiência no gerenciamento de eventos acadêmicos.
Utilizando o Room para persistência local e uma arquitetura modular baseada em DAOs, Managers e UI.
O projeto oferece uma base sólida para evolução e novas funcionalidades.

Ele pode servir tanto como uma solução prática para eventos reais quanto como um ótimo estudo de caso para quem deseja aprender Android nativo com boas práticas.
