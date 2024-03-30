package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {

    public Specification<Product> build(ProductParamsDTO productParamsDTO) {
        return withCategoryId(productParamsDTO.getCategoryId())
                .and(withPriceGt(productParamsDTO.getPriceGt()))
                .and(withPriceLt(productParamsDTO.getPriceLt()))
                .and(withRatingGt(productParamsDTO.getRatingGt()))
                .and(withTitleCont(productParamsDTO.getTitleCont()));
    }


    private Specification<Product> withCategoryId(Long categoryId) {
        return ((root, query, criteriaBuilder) -> categoryId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("category").get("id"), categoryId));
    }

    private Specification<Product> withPriceGt(Integer price) {
        return ((root, query, criteriaBuilder) -> price == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("price"), price));
    }

    private Specification<Product> withPriceLt(Integer price) {
        return ((root, query, criteriaBuilder) -> price == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.lessThan(root.get("price"), price));
    }

    private Specification<Product> withRatingGt(Double rating) {
        return ((root, query, criteriaBuilder) -> rating == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("rating"), rating));
    }

    private Specification<Product> withTitleCont(String subString) {
        return ((root, query, criteriaBuilder) -> subString == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + subString.toLowerCase() + "%"));
    }


}
// END
