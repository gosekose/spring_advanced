package hello.advanced.autoproxy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderService {

    public void orderItem(Item item) {
        item.minusQuantity();
        log.info("주문을 수행 합니다.");
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private class Item {
        private String name;
        private int quantity;

        public void minusQuantity() {

            if (checkQuantity()) {
                if (quantity > 0) {
                    quantity--;
                }
            }
        }

        private boolean checkQuantity () {
            if (quantity < 0) {
                throw new IllegalStateException("error");
            }
            return true;
        }
    }

}
