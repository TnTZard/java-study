## ElasticSearch

下载地址： https://elasticsearch.cn/download/

解压后运行 bin/ 下的 `elasicsearch.bat` 文件

![image-20210318100652117](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210318100652117.png)

可以看到需要jdk11，jdk8可能会出问题~~

![plan](C:\andy\ELK\elasticsearch\resource\plan.jpg)

### 一些基础概念

**节点Node、集群Cluster、分片Shards**

> ElasticSearch是分布式数据库，允许多台服务器协同工作，每台服务器可以运行多个实例。单个实例称为一个节点（Node），一组节点构成一个集群（Cluster）。分片是底层的工作单元，文档保存在分片内，分片又被分配到集群内的各个节点里，每个分片仅保存全部数据的一部分。

**索引Index、类型Type、文档Document**

对比mysql：

> index -> db
>
> type -> table
>
> document -> row

如果我们要访问一个文档元数据应该包括 `index/type/id` 这三种类型

> 插播一条烫知识：
>
> - 树型的查找时间复杂度一般是O(logn)
> - 链表的查找时间复杂度一般是O(n)
> - 哈希表的查找时间复杂度一般是O(1)
> - ....不同的数据结构所花的时间往往不一样，你想要查找的时候要**快**，就需要有底层的数据结构支持