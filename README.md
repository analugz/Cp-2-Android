# 📲 Bitcoin Monitor - App Android

Aplicativo desenvolvido em Kotlin com o propósito de acompanhar o preço atual do Bitcoin de forma simples, direta e com boa performance. O foco está no uso de boas práticas de arquitetura e integração com APIs REST usando Retrofit.

---

## 🧩 Sobre o projeto

A ideia principal foi criar uma ferramenta prática para quem quer checar rapidamente o valor do Bitcoin. A interface exibe informações essenciais como o nome da moeda e seu preço atualizado — tudo com atualização rápida e sem complicações.

---

## 🌐 Comunicação com a API

A aplicação utiliza uma API pública que fornece a cotação do Bitcoin. A integração foi feita com a biblioteca **Retrofit**, que facilita o envio de requisições HTTP e a conversão das respostas JSON para objetos Kotlin.

Toda a lógica de comunicação com a API foi encapsulada em uma interface específica (`CryptoApiService`), garantindo organização e facilitando a manutenção do código. A criação da instância do Retrofit é feita separadamente, por meio de uma fábrica (`ApiFactory`), o que evita duplicação e mantém o acesso centralizado.

---

## 🧱 Estrutura de Camadas

### 🔧 Service

A interface `CryptoApiService` define os endpoints disponíveis para o app. Isso deixa claro o que pode ser consultado na API e permite uma separação saudável entre a lógica de rede e o restante do app.

### 📦 Model

Os dados recebidos da API são representados por classes modeladas para refletir fielmente a estrutura do JSON. Essas classes servem como "recipientes" que o Retrofit preenche automaticamente com as informações retornadas.

### ⚙️ ViewModel

Aqui acontece a ponte entre os dados e a interface do usuário. O ViewModel é responsável por buscar as informações através da `CryptoApiService`, tratar eventuais erros e preparar os dados para serem exibidos na tela.

---

## 🎨 Interface com Jetpack Compose

Toda a parte visual do app foi construída com **Jetpack Compose**, uma abordagem moderna e mais fluida para criar interfaces em Android. Com Compose, a interface responde automaticamente a mudanças nos dados, como a oscilação do valor do Bitcoin.

O layout é simples: uma lista de criptomoedas mostrando nome, símbolo e preço atualizado. A comunicação com o ViewModel garante que os dados estejam sempre em dia.

---

## 📁 XML e Configurações

Apesar de o layout principal ser feito em Compose, ainda são utilizados arquivos XML importantes como o `AndroidManifest.xml` (onde ficam definidas permissões como o uso da internet) e arquivos de recursos (`res/values`) para temas, cores e textos traduzíveis.

---

## 🔗 API

A fonte dos dados de cotação é: https://www.mercadobitcoin.net/api/BTC/ticker/


---

## 📡 Requisições e Fluxo

Quando o usuário toca em "Atualizar", o app:

1. Envia uma requisição GET;
2. Recebe um JSON com os dados atualizados;
3. Converte os dados em objetos Kotlin;
4. Exibe o valor do Bitcoin em reais e a data/hora da cotação.

---

## 🧰 Tecnologias Utilizadas

- **Kotlin**: linguagem principal
- **Retrofit (2.9.0)**: comunicação com API
- **Gson Converter**: para conversão de JSON
- **Coroutines**: chamadas assíncronas
- **Jetpack Compose**: interface moderna
- **AndroidX & AppCompat**: compatibilidade
- **Activity-KTX**: extensões úteis para Android

---

Abaixo, duas capturas de tela da aplicação funcionando:

![437546229-dde3ee1e-9250-4e75-b10d-36ca0fba0a0e](https://github.com/user-attachments/assets/241989de-3046-403b-b32f-9017ede35f9c)

![437546555-8783f4d0-5106-439c-89a6-cb568049552f](https://github.com/user-attachments/assets/1bc8613c-c3e7-4ca7-a76c-74dc13deb9ba)

## 🛠️ Configuração da API

A base da API é definida na fábrica de serviços `MercadoBitcoinServiceFactory`, utilizando o seguinte padrão:

```kotlin
Retrofit.Builder()
    .baseUrl("https://www.mercadobitcoin.net/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()





