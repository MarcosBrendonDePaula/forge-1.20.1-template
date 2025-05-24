# Template de Mod Minecraft Forge 1.20.1

Este é um projeto template configurado para facilitar o desenvolvimento de mods para Minecraft 1.20.1 utilizando o Forge Mod Loader. Ele fornece uma estrutura básica e exemplos funcionais essenciais para iniciar rapidamente.

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

3.  **Estrutura de Packages Java**: O código fonte principal está em `src/main/java`. O template vem com um package `com.yourname.yourmodid`. **Renomeie** esta pasta para corresponder ao seu `mod_group_id` (ex: `com/seunome/meumodfantastico`). Faça o mesmo para as subpastas dentro de `src/main/resources/assets` e `src/main/resources/data`.
    *   Abra os ficheiros Java dentro de `src/main/java/com/yourname/yourmodid` (e suas subpastas `core/init`, `common/entity`, `client/renderer/entity`, `client/model`).
    *   Atualize as declarações de `package` e `import` na primeira linha para corresponder à nova estrutura (ex: `package com.seunome.meumodfantastico.core.init;`).
    *   Renomeie o ficheiro `YourModName.java` para algo mais descritivo para o seu mod (ex: `MeuModFantastico.java`).
    *   Atualize o nome da classe dentro do ficheiro para corresponder ao novo nome do ficheiro (ex: `public class MeuModFantastico`).
    *   Atualize a constante `MODID` dentro da classe principal para corresponder ao `mod_id` que definiu no `gradle.properties`.
    *   Atualize a anotação `@Mod(YourModName.MODID)` para usar o novo nome da classe (ex: `@Mod(MeuModFantastico.MODID)`).

4.  **Configuração do Ambiente de Desenvolvimento (IDE)**:
    *   Abra um terminal ou prompt de comando na pasta raiz do projeto.
    *   Execute o comando apropriado para o seu IDE:
        *   **IntelliJ IDEA**: `./gradlew genIntellijRuns`
        *   **Eclipse**: `./gradlew genEclipseRuns`
    *   Após a conclusão, importe o projeto no seu IDE como um projeto Gradle.

## Estrutura do Projeto (Atualizada)

*   `src/main/java/com/yourname/yourmodid`: Código fonte Java.
    *   `YourModName.java`: Classe principal do mod, onde os registos são inicializados.
    *   `core/init/`: Classes para registar diferentes elementos do mod.
        *   `BlockInit.java`: Registo de blocos.
        *   `ItemInit.java`: Registo de itens (incluindo comida, ferramentas, ovos de spawn).
        *   `FoodInit.java`: Definição de propriedades de comida.
        *   `EntityInit.java`: Registo de tipos de entidade (mobs).
        *   `CreativeTabInit.java`: Registo de abas criativas personalizadas.
    *   `common/entity/`: Classes para as entidades (mobs).
        *   `ExampleMobEntity.java`: Classe de exemplo para um mob passivo.
    *   `client/`: Código específico do lado do cliente (renderização, modelos).
        *   `model/ExampleMobModel.java`: Classe de modelo 3D para o mob (precisa ser criada/editada, ex: com Blockbench).
        *   `renderer/entity/ExampleMobRenderer.java`: Classe que renderiza o mob no jogo.
*   `src/main/resources`: Recursos do mod.
    *   `assets/yourmodid/`: Assets (texturas, modelos, sons, ficheiros de idioma).
        *   `lang/en_us.json`: Ficheiro de tradução para inglês (precisa ser criado para nomes de itens, blocos, tabs).
        *   `models/block/`: Modelos JSON para blocos.
        *   `models/item/`: Modelos JSON para itens.
        *   `textures/block/`: Texturas para blocos.
        *   `textures/item/`: Texturas para itens.
        *   `textures/entity/`: Texturas para mobs (ex: `example_mob.png`).
    *   `data/yourmodid/`: Data-driven features.
        *   `recipes/`: Receitas de crafting (ex: `example_block_from_example_item.json`).
        *   `loot_tables/`: Tabelas de loot para blocos e mobs (precisa ser criado).
    *   `META-INF/mods.toml`: Metadados do mod.
    *   `pack.mcmeta`: Metadados do resource pack.
*   `build.gradle`: Script de build.
*   `gradle.properties`: Propriedades de configuração.

## Exemplos Essenciais Incluídos

O template agora inclui exemplos básicos e comentados para:

*   **Bloco Simples (`BlockInit.java`, `example_block`)**: Um bloco básico com propriedades definidas (dureza, som, etc.).
    *   Precisa criar a textura em `assets/yourmodid/textures/block/example_block.png`.
    *   Precisa criar o modelo em `assets/yourmodid/models/block/example_block.json`.
    *   Precisa criar o estado do bloco em `assets/yourmodid/blockstates/example_block.json`.
    *   Precisa adicionar o nome em `assets/yourmodid/lang/en_us.json`: `"block.yourmodid.example_block": "Example Block"`.
*   **Item Simples (`ItemInit.java`, `example_item`)**: Um item básico sem funcionalidade especial.
    *   Precisa criar a textura em `assets/yourmodid/textures/item/example_item.png`.
    *   Precisa criar o modelo em `assets/yourmodid/models/item/example_item.json`.
    *   Precisa adicionar o nome em `assets/yourmodid/lang/en_us.json`: `"item.yourmodid.example_item": "Example Item"`.
*   **Comida (`ItemInit.java`, `FoodInit.java`, `example_food`)**: Um item comestível com propriedades definidas.
    *   Precisa criar a textura e modelo como um item normal.
    *   Precisa adicionar o nome em `assets/yourmodid/lang/en_us.json`: `"item.yourmodid.example_food": "Example Food"`.
*   **Ferramenta Básica (`ItemInit.java`, `example_pickaxe`)**: Uma picareta simples usando um tier existente (Ferro).
    *   Precisa criar a textura e modelo como um item normal.
    *   Precisa adicionar o nome em `assets/yourmodid/lang/en_us.json`: `"item.yourmodid.example_pickaxe": "Example Pickaxe"`.
*   **Mob Simples (`EntityInit.java`, `ExampleMobEntity.java`, `ExampleMobModel.java`, `ExampleMobRenderer.java`)**: Uma entidade passiva básica.
    *   Regista o tipo de entidade e seus atributos (vida, velocidade).
    *   Define a classe da entidade com IA básica (vagar, pânico, olhar).
    *   **Importante**: A classe `ExampleMobModel.java` é um *placeholder*. Precisa criar um modelo 3D (ex: usando Blockbench) e adaptar esta classe.
    *   **Importante**: Precisa criar a textura em `assets/yourmodid/textures/entity/example_mob.png`.
    *   Precisa registar o `LAYER_LOCATION` no `ExampleMobModel.java` e o renderer no `ClientModEvents` (já feito no template).
*   **Ovo de Spawn (`ItemInit.java`, `example_mob_spawn_egg`)**: Item para spawnar o mob customizado.
    *   Precisa adicionar o nome em `assets/yourmodid/lang/en_us.json`: `"item.yourmodid.example_mob_spawn_egg": "Example Mob Spawn Egg"`.
*   **Receita de Crafting (`resources/data/yourmodid/recipes/`)**: Exemplo de receita shaped para criar o `example_block` a partir do `example_item`.
*   **Aba Criativa (`CreativeTabInit.java`, `example_tab`)**: Uma aba personalizada no inventário criativo para organizar seus itens/blocos.
    *   Precisa adicionar o nome da aba em `assets/yourmodid/lang/en_us.json`: `"creativetab.yourmodid.example_tab": "Example Mod Tab"`.

**Nota sobre Assets**: Muitos dos exemplos requerem a criação de ficheiros JSON (modelos, blockstates, lang) e PNG (texturas) correspondentes dentro da pasta `src/main/resources/assets/yourmodid/`. O template fornece a estrutura de código, mas os assets visuais e de dados precisam ser criados por si.

## Compilar o Mod

Para compilar o seu mod num ficheiro JAR:

1.  Abra um terminal na pasta raiz do projeto.
2.  Execute: `./gradlew build`
3.  O JAR estará em `build/libs/`. Use o ficheiro que **não** contém `-sources` ou `-dev`.

## Publicação no GitHub

Este template está pronto para Git. Após a configuração inicial:

1.  Se ainda não o fez: `git init`, `git add .`, `git commit -m "Initial commit"`
2.  Adicione o remoto: `git remote add origin URL_DO_SEU_REPOSITORIO`
3.  Envie: `git push -u origin main` (ou `master`).

Use o seu token do GitHub para autenticar o push.

