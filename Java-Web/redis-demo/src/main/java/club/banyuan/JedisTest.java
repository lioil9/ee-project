package club.banyuan;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        //连接池中的最大连接数，默认值为8
        config.setMaxTotal(50);
        //连接池中的最大空闲连接数量，默认为8
        config.setMaxIdle(10);

        //一般通过jedis工具连接redis创建对象
        Jedis jedis = new Jedis("localhost",6379);
        jedis.del("user1");
        System.out.println(jedis.get("user1"));
        System.out.println(jedis.get("user2"));

        //通过连接池创建jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        Jedis jedis1 = jedisPool.getResource();
        System.out.println(jedis1.get("user2"));

    }
}
