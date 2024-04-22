# Sistema de Gerenciamento de Aquário
O sistema de gerenciamento de aquário é uma aplicação projetada para facilitar o cuidado e a manutenção de aquários, comerciais ou públicos. Ele oferece recursos para monitorar e controlar diversos aspectos do ambiente aquático, garantindo o bem-estar dos animais e a saúde do ecossistema.
## Estrutura de classes

### Animais (Principal)
- **Animais** (Jonhnathan) e Colaborativa.
- **Descrição**: Classe principal para gerenciar animais no sistema.
- **Responsabilidades**:
    - Manter informações gerais sobre os animais.
    - Relacionar-se com subclasses específicas.
- **Subclasses**:
    - **Peixe** (Mauricio)
    - **Tartaruga** (Ricardo)
    - **Arraia** (Jonhnathan)

**Entrega:** 07/04

### Funcionários
- **Funcionários** (Jonhnathan)
- **Descrição**: Classe para gerenciar funcionários do aquário.
- **Responsabilidades**:
    - Registrar informações sobre funcionários.
    - Distinguir entre diferentes tipos de funcionários.
- **Subclasses**:
    - **Gerente** (Mauricio)
    - **Veterinário** (Mauricio)

**Entrega:** 14/04

### Local
- **Local** (Ricardo)
- **Descrição**: Classe para gerenciar os locais no aquário.
- **Responsabilidades**:
    - Manter informações sobre os tanques e outros espaços.
    - Relacionar-se com o sistema de arquivos ou banco de dados.
- **Subclasses**:
    - **Tanque** (Ricardo)
    - **Arquivo/Banco de dados**

**Entrega:** 21/04

## Arquivo de Teste
- **Nome**: `GerenciamentoAquario`

## Créditos
- Jonhnathan
- Mauricio
- Ricardo