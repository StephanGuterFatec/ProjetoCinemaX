CREATE TABLE IF NOT EXISTS TIPO_SALA (
  cd_tipo_sala SERIAL NOT NULL,
  nm_tipo_sala VARCHAR(50) NOT NULL,
  ds_tipo_sala VARCHAR(255) NOT NULL,
  PRIMARY KEY (cd_tipo_sala)
);

CREATE TABLE IF NOT EXISTS SALA (
  cd_sala SERIAL NOT NULL,
  nm_sala VARCHAR(10) NOT NULL,
  cd_tipo_sala INT NOT NULL,
  PRIMARY KEY (cd_sala),
  CONSTRAINT FK_SALA_TIPO_SALA
    FOREIGN KEY (cd_tipo_sala)
    REFERENCES TIPO_SALA (cd_tipo_sala)
);

CREATE TABLE IF NOT EXISTS GENERO_FILME (
  cd_genero_filme SERIAL NOT NULL,
  nm_genero_filme VARCHAR(50) NOT NULL,
  PRIMARY KEY (cd_genero_filme)
);

CREATE TABLE IF NOT EXISTS FILME (
  cd_filme SERIAL NOT NULL,
  nm_filme VARCHAR(100) NOT NULL,
  ds_sinopse_filme TEXT NOT NULL,
  qt_minutos_duracao INT NOT NULL,
  cd_idade_classificacao INT NOT NULL,
  dt_lancamento_filme TIMESTAMP NOT NULL,
  cd_genero_filme INT NOT NULL,
  PRIMARY KEY (cd_filme),
  CONSTRAINT FK_FILME_GENERO_FILME
    FOREIGN KEY (cd_genero_filme)
    REFERENCES GENERO_FILME (cd_genero_filme)
);

CREATE TABLE IF NOT EXISTS EXIBICAO (
  dt_exibicao TIMESTAMP NOT NULL,
  cd_sala INT NOT NULL,
  cd_filme INT NOT NULL,
  ic_audio_original BOOLEAN NOT NULL,
  PRIMARY KEY (dt_exibicao, cd_sala),
  CONSTRAINT FK_EXIBICAO_SALA
    FOREIGN KEY (cd_sala)
    REFERENCES SALA (cd_sala),
  CONSTRAINT FK_EXIBICAO_FILME
    FOREIGN KEY (cd_filme)
    REFERENCES FILME (cd_filme)
);