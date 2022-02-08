package 程序员代码面试指南.猫狗队列;

/**
 * @Author: anzhi
 * @Date: 2021/3/30 15:30
 */
public class PetEnterQueue {

    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterPetType() {
        return this.pet.getPetType();
    }

}
