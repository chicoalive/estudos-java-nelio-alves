// Por que criamos: Entidade para demonstrar programação funcional
package model.etities;

// Modelo de dados Produto com nome e preço
public class Product {
    // Por que atributos privados: Encapsulamento dos dados
    private String nameProduct;
    private Double priceProduct;

    // Por que construtor: Inicialização obrigatória de nome e preço
    public Product(String nameProduct, Double priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {

        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    // Por que toString: Formatação padrão para exibição do produto
    @Override
    public String toString() {
        return "Produto: " + nameProduct + "\n"
                + ". Preço R$ " + String.format("%.2f", priceProduct);
    }
}
