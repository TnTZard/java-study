package 程序员代码面试指南.猫狗队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: anzhi
 * @Date: 2021/3/30 15:28
 */
public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;

    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("error, not dog or cat");
        }
    }

    /**
     * 用户可以调用pollAll方法，
     * 将队列中所有的实例按照进队列的先后顺序依次弹出
     * @return
     */
    public Pet pollAll() {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("error, queue is empty!");
        }
    }

    public Dog pollDog() {
        if (this.isDogQueueEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("error, Dog queue is empty!");
        }
    }

    public Cat pollCat() {
        if (!this.isDogQueueEmpty()) {
            return (Cat) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("error, Dog queue is empty!");
        }
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }


    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }

}
