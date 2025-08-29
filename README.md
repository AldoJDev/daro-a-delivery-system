# 🥕 DáRoça - Sistema de Gestão e Otimização de Entregas

Uma solução completa para a gestão de logística e otimização de rotas, projetada para a distribuição de produtos frescos diretamente do produtor ao consumidor final.

## 📋 Sobre o Projeto

O **DáRoça** é um projeto de software que aborda os desafios logísticos na distribuição de alimentos frescos. Desenvolvido como um estudo de caso acadêmico, o sistema substitui processos manuais de planejamento de rotas por uma plataforma automatizada e de alta eficiência, que utiliza o algoritmo do Problema do Caixeiro Viajante (PCV) para garantir as rotas mais eficientes.

A solução foi concebida para um cenário operacional com 3 centros de distribuição estrategicamente localizados (Campinas, Piracicaba e Guarulhos), otimizando a logística em uma ampla área geográfica.

### 🎯 O Desafio

Empresas de entrega de produtos frescos frequentemente enfrentam desafios como:

*   Ineficiências e erros decorrentes do planejamento manual de rotas.
*   Dificuldade em coordenar a distribuição entre múltiplos centros operacionais.
*   Altas taxas de cancelamento de pedidos recorrentes devido a falhas na entrega.
*   Custos operacionais elevados que impactam a margem de lucro.

O DáRoça foi projetado para solucionar diretamente esses problemas, oferecendo uma plataforma centralizada e inteligente.

## 🏢 Cenário de Operação

### Centros de Distribuição
- **Campinas** - Atendendo o interior de SP.
- **Piracicaba** - Atendendo o interior de SP.
- **Guarulhos** - Atendendo a Grande São Paulo.

### Modelos de Entrega
O sistema suporta múltiplos modelos de assinatura e compras avulsas:
- ✅ **Única Vez**: Pedidos esporádicos.
- 📅 **Semanal**: Entregas a cada 7 dias.
- 📆 **Quinzenal**: Entregas a cada 15 dias.
- 🗓️ **Mensal**: Entregas a cada 30 dias.

### Parâmetros Operacionais
- **Janela de Entrega**: Os pedidos são entregues em um prazo máximo de 12 a 16 horas.
- **Jornada do Motorista**: Das 07:00 às 16:00, com pausa das 12:00 às 13:00.
- **Checklist do Veículo**: Realizado diariamente das 07:00 às 07:15.

## 🚀 Principais Funcionalidades

### Para Analistas de Logística
- **Dashboard Centralizado**: Painel de controle para monitoramento em tempo real das operações.
- **Geração Automática de Rotas**: Criação de rotas otimizadas com base nos pedidos do dia.
- **Monitoramento de Entregas**: Acompanhamento do progresso das entregas e status dos motoristas.
- **Balanceamento de Carga**: Redistribuição inteligente de motoristas entre os centros de distribuição conforme a demanda.

### Para Motoristas
- **Visualização de Rotas Otimizadas**: Acesso a rotas diárias através de uma interface clara e intuitiva.
- **Controle de Jornada**: Ferramentas para registro de início, pausa e fim de turno.
- **Gestão de Pedidos**: Lista detalhada de pedidos, endereços e status de entrega.

### Para Centros de Distribuição
- **Gestão de Estoque**: Controle de entrada e saída de produtos.
- **Coordenação de Pedidos**: Sincronização e compartilhamento de pedidos entre os centros.
- **Previsão de Demanda**: Ferramentas para análise e controle da demanda operacional.

## 🛠️ Pilha de Tecnologias 

### Backend
- **Linguagem**: Java 17+
- **Framework**: Spring Boot
- **Banco de Dados**: Microsoft SQL Server

### Frontend
- **Linguagem**: TypeScript
- **Biblioteca**: React.js

## 🚀 Como Executar

### Pré-requisitos

- Java 17+
- Node.js 16+
- Microsoft SQL Server
- Maven

### Execução do Backend

```bash
cd backend
mvn spring-boot:run
```

### Execução do Frontend

```bash
cd frontend
npm install
npm start
```

## 🔧 Funcionamento

### Estrutura da Aplicação

A arquitetura segue um modelo cliente-servidor desacoplado:

```
Frontend (React + TypeScript)
        ↕
Backend API (Spring Boot + Java)
        ↕
Database (SQL Server)
```

### Módulos Principais (Telas)

O sistema é organizado em 6 módulos principais:

1.  **Login**: Autenticação de usuários.
2.  **Programação**: Seleção de centro e data para planejamento.
3.  **Centro de Distribuição**: Gestão de pedidos e recursos do centro.
4.  **Motoristas**: Gerenciamento da frota e atribuição de motoristas.
5.  **Pedidos**: Visualização e gerenciamento de todos os pedidos.
6.  **Rotas**: Visualização e ajuste das rotas geradas.


## 📚 Base Teórica

A funcionalidade central de otimização de rotas é baseada no **Problema do Caixeiro Viajante (PCV)**, um problema clássico de otimização combinatória. O objetivo é encontrar o menor caminho possível que visita um conjunto de cidades (neste caso, endereços de entrega) exatamente uma vez, retornando ao ponto de partida (o centro de distribuição).
