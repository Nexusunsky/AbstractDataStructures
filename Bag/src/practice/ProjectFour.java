package practice;

/**
 * 4，一盒 扑克牌 中含有一些标准的 卡牌。盒中的这些牌 可以洗牌，然后一次打出一张牌。也可以计算盒中牌的张数。
 * <p>
 * 当一把牌打完后，应该将所有的牌放回盒中并洗牌，有些纸牌游戏要求，当牌盒变空时，弃牌堆中的牌要放回盒中。
 * 然后重洗盒中的牌。在本例中，不是所有的牌都在盒中；有些牌被玩家拿着。
 * <p>
 * 设计一个盒的ADT，假定有类PlayingCard，纸牌可以被认为是牌张数为1的一个盒。
 * <p>
 * 说明 每个 ADT 操作，说明方法的目的，描述它的参数；写方法头的伪代码。然后写一个用于盒的方法的Java接口。javadoc注释
 * 然后重洗盒中的牌，
 *
 * @author: haoliu on 06/08/2018 22:25
 */
public class ProjectFour {
    interface BasePlayingCard<T> {
        /**
         * Get current number Card size.
         *
         * @return The integer number of playing card size.
         */
        int getCurrentSize();

        /**
         * Sees whether this playing-cards is empty.
         *
         * @return True if the playing-cards is empty or false if not.
         */
        boolean isEmpty();

        /**
         * 当牌打完以后，将弃牌回收
         */
        void reload();

        /**
         * 当牌局结束以后，洗牌
         */
        void shuffle();

        /**
         * 出牌
         *
         * @return T 打出的一张牌
         */
        T play();
    }
}
