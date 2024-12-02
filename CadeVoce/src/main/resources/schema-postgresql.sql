-- Criando a tabela pessoa_desaparecida
CREATE TABLE IF NOT EXISTS pessoa_desaparecida (
id UUID PRIMARY KEY NOT NULL,
nome VARCHAR(200) NOT NULL,
idade_desaparecimento INTEGER,
data_desaparecimento DATE,
cidade_desaparecimento VARCHAR(100),
estado VARCHAR(2),
-- Informações pessoais
sexo VARCHAR(20),
cor_pele VARCHAR(50),
cor_cabelo VARCHAR(50),
tipo_cabelo VARCHAR(50),
altura DECIMAL(3,2),
peso DECIMAL(5,2),
-- Descrição do desaparecimento
descricao_desaparecimento TEXT,
ultima_localizacao_conhecida VARCHAR(200),
-- Informações familiares
nome_mae VARCHAR(200),
nome_pai VARCHAR(200),
nome_responsavel VARCHAR(200),
contato_responsavel VARCHAR(20),
-- Fotos
foto_antiga BYTEA,
foto_atual BYTEA,
PessoaDesaparecidaRepository.java
PessoaDesaparecida
-- Metadados
data_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
status_caso VARCHAR(50) DEFAULT 'ATIVO',
-- Informações adicionais
caracteristicas_marcantes TEXT,
roupas_ultimo_avistamento TEXT
);
-- Criando índices para as colunas que serão frequentemente consultadas
CREATE INDEX IF NOT EXISTS idx_nome ON pessoa_desaparecida(nome);
CREATE INDEX IF NOT EXISTS idx_data_desaparecimento ON pessoa_desaparecida(data_desaparecimento);
CREATE INDEX IF NOT EXISTS idx_cidade ON pessoa_desaparecida(cidade_desaparecimento);