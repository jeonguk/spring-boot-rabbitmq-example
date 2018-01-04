package com.jeonguk.web.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jeonguk.web.entity.Product;
import com.jeonguk.web.repository.ProductRepository;

/**
 * This is the queue listener class, its receiveMessage() method ios invoked with the
 * message as the parameter.
 */
@Component
public class ProductMessageListener {

    private ProductRepository productRepository;

    private static final Logger log = LoggerFactory.getLogger(ProductMessageListener.class);

    public ProductMessageListener(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * This method is invoked whenever any new message is put in the queue.
     * See {@link com.jeonguk.web.SpringBootRabbitmqExampleApplication} for more details
     * @param message
     */
    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        Long id = Long.valueOf(message.get("id"));
        Product product = productRepository.findById(id).orElse(null);
        product.setMessageReceived(true);
        product.setMessageCount(product.getMessageCount() + 1);

        productRepository.save(product);
        log.info("Message processed...");
    }
    
}