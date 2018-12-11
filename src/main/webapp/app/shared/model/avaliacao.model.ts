import { Moment } from 'moment';
import { IItemAvaliado } from 'app/shared/model/item-avaliado.model';
import { IItemAuditado } from 'app/shared/model/item-auditado.model';
import { IItemSolicitadoAjuste } from 'app/shared/model/item-solicitado-ajuste.model';

export const enum StatusAvaliacao {
  INICIADA = 'INICIADA',
  CHECKLIST_FINALIZADO = 'CHECKLIST_FINALIZADO',
  ANEXO_AUDITORIA_FINALIZADO = 'ANEXO_AUDITORIA_FINALIZADO',
  ANEXO_SOLICITACAO_AJUSTE_FINALIZADO = 'ANEXO_SOLICITACAO_AJUSTE_FINALIZADO',
  SUBMETIDO = 'SUBMETIDO'
}

export const enum CriticidadePainel {
  INADMISSIVEL = 'INADMISSIVEL',
  CONTROLE = 'CONTROLE',
  VALOR_ELEVADO = 'VALOR_ELEVADO',
  CRITICO = 'CRITICO',
  ATENCAO = 'ATENCAO'
}

export const enum NivelEficiencia {
  A = 'A',
  B = 'B',
  C = 'C',
  D = 'D',
  E = 'E'
}

export const enum StatusItemAvaliado {
  OK = 'OK',
  NAO_OK = 'NAO_OK',
  N_A = 'N_A'
}

export const enum CategorizacaoPerdaQuebra {
  INADMISSIVEL = 'INADMISSIVEL',
  CRITICO = 'CRITICO',
  VALOR_ELEVADO = 'VALOR_ELEVADO',
  ATENCAO = 'ATENCAO',
  CONTROLE = 'CONTROLE',
  SOBRA_DESCONTROLE = 'SOBRA_DESCONTROLE'
}

export interface IAvaliacao {
  id?: number;
  iniciadaEm?: Moment;
  latitudeInicioAvaliacao?: number;
  longitudeInicioAvaliacao?: number;
  nomeResponsavelLoja?: string;
  prontuarioResponsavelLoja?: number;
  submetidoEm?: Moment;
  latitudeSubmissaoAvaliacao?: number;
  longitudeSubmissaoAvaliacao?: number;
  observacaoSubmissaoEnviadaForaDaLoja?: string;
  status?: StatusAvaliacao;
  criticidadePainel?: CriticidadePainel;
  nivelEficienciaGeral?: NivelEficiencia;
  nivelEficienciaProcedimento?: NivelEficiencia;
  nivelEficienciaPessoa?: NivelEficiencia;
  nivelEficienciaProcesso?: NivelEficiencia;
  nivelEficienciaProduto?: NivelEficiencia;
  canceladoEm?: Moment;
  motivoCancelamento?: string;
  percentualPerda?: number;
  financeiroPerda?: number;
  pontuacaoPerda?: number;
  statusPerda?: StatusItemAvaliado;
  categorizacaoPerda?: CategorizacaoPerdaQuebra;
  percentualQuebra?: number;
  financeiroQuebra?: number;
  pontuacaoQuebra?: number;
  statusQuebra?: StatusItemAvaliado;
  categorizacaoQuebra?: CategorizacaoPerdaQuebra;
  importadoViaPlanilha?: boolean;
  caminhoArquivoPlanilha?: string;
  itensAvaliados?: IItemAvaliado[];
  itensAuditados?: IItemAuditado[];
  itensComAjusteSolicitados?: IItemSolicitadoAjuste[];
  avaliadorName?: string;
  avaliadorId?: number;
  questionarioNome?: string;
  questionarioId?: number;
  lojaNome?: string;
  lojaId?: number;
}

export const defaultValue: Readonly<IAvaliacao> = {
  importadoViaPlanilha: false
};
