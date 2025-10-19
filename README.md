# TaskFlow — Sistema de Gerenciamento de Tarefas (Protótipo)

**Resumo:** Projeto da TechFlow Solutions: protótipo de um sistema de gerenciamento de tarefas baseado em metodologias ágeis para uma startup de logística. Implementação mínima: CRUD de tarefas, Kanban no GitHub Projects, pipeline CI com GitHub Actions e testes automatizados.

## Objetivo
Entregar um repositório público que demonstre o ciclo de desenvolvimento ágil: planejamento (Kanban), desenvolvimento incremental (commits), testes automatizados e gestão de mudanças.

## Escopo inicial
- CRUD de tarefas (title, description, status).
- API REST com Spring Boot.
- Banco em memória (H2) para facilitar execução local.
- GitHub Projects: quadro Kanban (A Fazer, Em Progresso, Concluído).
- GitHub Actions: execute `mvn test` em cada push/PR.
- Pelo menos 10 commits com mensagens claras.

## Como executar localmente
1. Clone o repositório:
```bash
git clone https://github.com/<https://github.com/destroyergamer2021-png/taskflow.git>/taskflow.git
cd taskflow
