package assgnment;

public class Question6 {

    public enum OrderStatus {
        PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED, REFUNDED
    }

    public static String processOrderStatus(OrderStatus status) {
        return switch (status) {
            case PENDING -> "Order is awaiting confirmation.";
            case PROCESSING -> "Order is being prepared.";
            case SHIPPED -> "Order has been dispatched.";
            case DELIVERED -> "Order has been successfully delivered.";
            case CANCELLED -> "Order has been canceled.";
            case REFUNDED -> {
                double partialRefund = Math.random() * 100;
                yield "Refund has been issued for the order: %.2f%%".formatted(partialRefund);
            }
        };
    }

    public static void main(String[] args) {
        for(OrderStatus status: OrderStatus.values()){
            System.out.println(status + ": " + processOrderStatus(status));
        }
    }
}

