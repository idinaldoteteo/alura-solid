package br.com.alura.rh.model;

public enum Cargo {

	ASSISTENTE {
		@Override
		public Cargo getProximo() {
			return ANALISTA;
		}
	},
	ANALISTA {
		@Override
		public Cargo getProximo() {
			return ESPECIALISTA;
		}
	},
	ESPECIALISTA {
		@Override
		public Cargo getProximo() {
			return GERENTE;
		}
	},
	GERENTE {
		@Override
		public Cargo getProximo() {
			return GERENTE;
		}
	};

	public abstract Cargo getProximo();

}
