
public enum StatusPedido {

    AGUARDANDO,
    PAGO,
    ENVIADO,
    ENTREGUE,
    CANCELADO

}

public class Pedido {

    private StatusPedido status;

    public Pedido() {
        status = StatusPedido.AGUARDANDO;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void avancar() {

        switch (status) {

            case AGUARDANDO:
                status = StatusPedido.PAGO;
                break;

            case PAGO:
                status = StatusPedido.ENVIADO;
                break;

            case ENVIADO:
                status = StatusPedido.ENTREGUE;
                break;

            default:
                throw new IllegalStateException(
                    "Nao e possivel avancar esse pedido!"
                );

        }

    }

    public void cancelar() {

        if (status == StatusPedido.ENTREGUE ||
            status == StatusPedido.CANCELADO) {

            throw new IllegalStateException(
                "Nao e possivel cancelar esse pedido!"
            );

        }

        status = StatusPedido.CANCELADO;

    }

}
