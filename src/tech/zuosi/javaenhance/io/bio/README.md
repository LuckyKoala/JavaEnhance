## 面向流 & 阻塞

Java IO是面向流的，每次从流（InputStream/OutputStream）中读一个或多个字节，直到读取完所有字节，它们没有被缓存在任何地方。另外，它不能前后移动流中的数据，如需前后移动处理，需要先将其缓存至一个缓冲区。

Java IO的各种流是阻塞的。当某个线程调用read()或write()方法时，该线程被阻塞，直到有数据被读取到或者数据完全写入。阻塞期间该线程无法处理任何其它事情。

## 服务器实现

IOServer 单个线程处理所有请求
IOServerMultiThread 为每个请求创建一个线程
IOServerThreadPool 使用线程池处理请求