package br.com.eldorado.handsonsemana2matheuswiener.domain.enums;

public enum ClassificacaoImc {

    MAGREZA("Magreza"),
    NORMAL("Normal"),
    SOBREPESO("Sobrepeso"),
    OBESIDADE("Obesidade"),
    OBESIDADE_GRAVE("Obesidade Grave"),
    ;

    private final String text;

    /**
     * @param text
     */
    ClassificacaoImc(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
