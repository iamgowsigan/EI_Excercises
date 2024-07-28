//Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to collaborate.
// It acts as a bridge between two incompatible interfaces. This pattern involves a single class called adapter which is responsible for joining functionalities of independent or incompatible interfaces.

package Structural_Design_Patterns;

// Target interface
interface PaymentGateway {
    void processPayment(String paymentDetails);
}

// Adaptee 1
class PayPal {
    void makePayment(String details) {
        System.out.println("Processing payment through PayPal: " + details);
    }
}

// Adaptee 2
class Stripe {
    void chargePayment(String details) {
        System.out.println("Processing payment through Stripe: " + details);
    }
}

// Adapter for PayPal
class PayPalAdapter implements PaymentGateway {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(String paymentDetails) {
        payPal.makePayment(paymentDetails);
    }
}

// Adapter for Stripe
class StripeAdapter implements PaymentGateway {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(String paymentDetails) {
        stripe.chargePayment(paymentDetails);
    }
}

// Main class to demonstrate
public class AdapterPatternDemo {
    public static void main(String[] args) {
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();

        PaymentGateway payPalAdapter = new PayPalAdapter(payPal);
        PaymentGateway stripeAdapter = new StripeAdapter(stripe);

        payPalAdapter.processPayment("PayPal Payment Details");
        stripeAdapter.processPayment("Stripe Payment Details");
    }
}
