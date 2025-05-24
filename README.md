# Template de Mod Minecraft Forge 1.20.1

Este é um projeto template configurado para facilitar o desenvolvimento de mods para Minecraft 1.20.1 utilizando o Forge Mod Loader. Ele fornece uma estrutura básica e um exemplo funcional para iniciar rapidamente.

## Configuração Inicial

Antes de começar a desenvolver o seu mod, precisa de configurar algumas informações básicas do projeto.

1.  **`gradle.properties`**: Abra este ficheiro e edite as seguintes propriedades na secção `## Mod Properties (CONFIGURE THESE)`:
    *   `mod_id`: O identificador único do seu mod (ex: `meumodfantastico`). **Deve ser tudo em minúsculas, sem espaços ou caracteres especiais, exceto underscore (`_`)**. Este ID será usado internamente e nos nomes de ficheiros.
    *   `mod_name`: O nome legível do seu mod (ex: `Meu Mod Fantástico`).
    *   `mod_license`: A licença sob a qual o seu mod será distribuído (ex: `MIT`, `ARR` para All Rights Reserved). Consulte [Choose an open source license](https://choosealicense.com/) para mais opções.
    *   `mod_version`: A versão inicial do seu mod (ex: `1.0.0`). Siga a convenção [SemVer](https://semver.org/).
    *   `mod_group_id`: O group ID usado para publicação Maven (geralmente o seu package base, ex: `com.seunome.meumodfantastico`).
    *   `mod_authors`: O seu nome ou nomes dos autores.
    *   `mod_description`: Uma breve descrição do seu mod.

2.  **`src/main/resources/META-INF/mods.toml`**: Este ficheiro usa as propriedades definidas no `gradle.properties`. Normalmente, **não precisa de o editar diretamente** para as configurações básicas, pois ele busca os valores como `${mod_id}`, `${mod_name}`, etc. Verifique se os valores correspondem ao esperado.

3.  **Estrutura de Packages Java**: O código fonte principal está em `src/main/java`. O template vem com um package `com.yourname.yourmodid`. **Renomeie** esta pasta para corresponder ao seu `mod_group_id` (ex: `com/seunome/meumodfantastico`).
    *   Abra o ficheiro `src/main/java/com/yourname/yourmodid/YourModName.java`.
    *   Atualize a declaração do package na primeira linha para corresponder à nova estrutura (ex: `package com.seunome.meumodfantastico;`).
    *   Renomeie o ficheiro `YourModName.java` para algo mais descritivo para o seu mod (ex: `MeuModFantastico.java`).
    *   Atualize o nome da classe dentro do ficheiro para corresponder ao novo nome do ficheiro (ex: `public class MeuModFantastico`).
    *   Atualize a constante `MODID` dentro da classe para corresponder ao `mod_id` que definiu no `gradle.properties`.
    *   Atualize a anotação `@Mod(YourModName.MODID)` para usar o novo nome da classe (ex: `@Mod(MeuModFantastico.MODID)`).

4.  **Configuração do Ambiente de Desenvolvimento (IDE)**:
    *   Abra um terminal ou prompt de comando na pasta raiz do projeto.
    *   Execute o comando apropriado para o seu IDE:
        *   **IntelliJ IDEA**: `./gradlew genIntellijRuns`
        *   **Eclipse**: `./gradlew genEclipseRuns`
    *   Após a conclusão, importe o projeto no seu IDE como um projeto Gradle.

## Estrutura do Projeto

*   `src/main/java`: Contém o código fonte Java do seu mod.
*   `src/main/resources`: Contém os recursos do seu mod:
    *   `assets/yourmodid/`: Pasta para assets como texturas, modelos, ficheiros de idioma (substitua `yourmodid` pelo seu `mod_id`).
    *   `data/yourmodid/`: Pasta para data-driven features como receitas, tags, loot tables (substitua `yourmodid` pelo seu `mod_id`).
    *   `META-INF/mods.toml`: Ficheiro de metadados do mod.
    *   `pack.mcmeta`: Ficheiro de metadados do resource pack.
*   `build.gradle`: Script de build do Gradle, define dependências e tarefas.
*   `gradle.properties`: Propriedades de configuração do build e do mod.

## Exemplo Incluído

O template inclui um exemplo básico que regista:
*   Um bloco simples (`EXAMPLE_BLOCK`).
*   Um item correspondente para o bloco (`EXAMPLE_BLOCK_ITEM`).
*   Um item consumível (`EXAMPLE_ITEM`).
*   Uma aba personalizada no criativo (`EXAMPLE_TAB`).

Pode encontrar o código de registo em `YourModName.java` (ou como o renomeou). Sinta-se à vontade para modificar ou remover este exemplo conforme desenvolve o seu próprio mod.

## Compilar o Mod

Para compilar o seu mod num ficheiro JAR pronto para ser usado no Minecraft:

1.  Abra um terminal ou prompt de comando na pasta raiz do projeto.
2.  Execute o comando: `./gradlew build`
3.  O ficheiro JAR compilado estará localizado em `build/libs/`. O ficheiro que **não** contém `-sources` ou `-dev` no nome é o JAR final do mod.

## Publicação no GitHub

Este template está pronto para ser versionado com Git. Após a configuração inicial:

1.  Inicialize um repositório Git: `git init`
2.  Adicione os ficheiros: `git add .`
3.  Faça o commit inicial: `git commit -m "Initial commit with Forge MDK template"`
4.  Adicione o repositório remoto do GitHub: `git remote add origin URL_DO_SEU_REPOSITORIO`
5.  Envie para o GitHub: `git push -u origin main` (ou `master`, dependendo do nome do seu branch principal).

Lembre-se de manter o seu token do GitHub seguro e usá-lo conforme necessário para autenticar operações push.

