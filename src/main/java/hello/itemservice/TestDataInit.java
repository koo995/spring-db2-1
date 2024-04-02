package hello.itemservice;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;

    /**
     * 확인용 초기 데이터 추가
     * EventListener 은 뭐냐? 어떤 이벤트 타이밍에 아래의 메소드를 호출하는 것이다.
     * 참고로 이 기능 대신 @PostConstruct 를 사용할 경우 AOP 같은 부분이 아직 다 처리되지 않은 시점에 호출될 수 있기 때문에,
     * 간목 문제가 발생할 수 있다. 예를 들어 @Transaction 과 관련된 AOP 가 적용되지 않은 상태로 호출될 수 있다.
     * 당연한거지만 TestDataInit 클래스는 스프링빈으로 등록되어 있어야 한다.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("test data init");
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}
