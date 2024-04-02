package hello.itemservice.repository;

import hello.itemservice.domain.Item;

import java.util.List;
import java.util.Optional;

/**
 * ItemUpdateDto, ItemSearchCond 이 두 녀석은 ItemRepository에만 존재하며, ItemRepository 에서 사용하기 위해서 쓰인 dto다.
 * 즉 ItemRepository 에 의존관계를 가지는데, 이 두 녀석의 패키지를 serivce 에 두면, service 에서 repository 에 의존관계를 가지게 되는 것이다.
 * 패키지의 순환참조랄까? 이런 문제를 방지하기 위해서 dto 는 repository 에 두는 것이 좋다.
 * dto 을 어디에 놔둬야하냐? dto 를 마지막으로 가지고 있는 곳이 어디냐를 중심으로 생각하자. service 에서 끝난다면 service 에 두는 것이 맞다.
 * 약간 애매하다? 그러면 별도의 패키지에 넣어둔다.
 */
public interface ItemRepository {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond cond);

}
