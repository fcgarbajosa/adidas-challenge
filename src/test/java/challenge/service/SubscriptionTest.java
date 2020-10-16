package challenge.service;

import challenge.jpa.entities.Subscription;
import challenge.jpa.repositories.SubscriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SubscriptionTest {

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @InjectMocks
    private final SubscriptionService subscriptionService = new SubscriptionServiceImpl();


    private final Optional<Subscription> subscription = Optional.of(new Subscription());

    @BeforeEach
    void setMockOutput() {

        when(subscriptionRepository.findAll()).thenReturn(new ArrayList<Subscription>());
        when(subscriptionRepository.findById(1L)).thenReturn(subscription);
        when(subscriptionRepository.findById(2L)).thenReturn(Optional.empty());
        // when(subscriptionRepository.findById(2L)).thenThrow(NoSuchElementException.class);
        when(subscriptionRepository.save(subscription.get())).thenReturn(subscription.get());

    }

    @DisplayName("Test SubscriptionService.findAll()")
    @Test
    public void testFindAll() throws Exception {

        assertEquals(new ArrayList<Subscription>(), subscriptionService.findAll());
    }

    @DisplayName("Test SubscriptionService.getsubscriptionByIdOk()")
    @Test
    void findByIdOk() {

        assertEquals(subscription.get(), subscriptionService.getSubscriptionById(1L));
    }

    @DisplayName("Test SubscriptionService.getsubscriptionByIdFail()")
    @Test
    void findByIdFail() {

        assertNull(subscriptionService.getSubscriptionById(2L));
    }

    @DisplayName("Test SubscriptionService.newsubscription()")
    @Test
    void savesubscriptionNew() {

        assertEquals(subscription.get(), subscriptionService.newSubscription(subscription.get()));
    }

    @DisplayName("Test SubscriptionService.updatesubscriptionIdOk()")
    @Test
    void updatesubscriptionIdOk() {

        assertEquals(subscription.get(), subscriptionService.updateSubscription(subscription.get(), 1L));
    }

    @DisplayName("Test SubscriptionService.updatesubscriptionIdNotOk()")
    @Test
    void updatesubscriptionIdNotOk() {

        assertNull(subscriptionService.updateSubscription(subscription.get(), 2L));
    }

    @DisplayName("Test SubscriptionService.deleteByIdOk()")
    @Test
    void deletesubscriptionByIdOk() {

        assertEquals(subscription.get(), subscriptionService.deleteSubscription(1L));
    }

    @DisplayName("Test SubscriptionService.deleteByIdNotOk()")
    @Test
    void deletesubscriptionByIdNotOk() {

        assertEquals(null, subscriptionService.deleteSubscription(2L));
    }
}
