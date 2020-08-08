# crawler_with_elastic
An java crawler project with elastic_search

## todo list
- [x] set the basic maven frame support
- [x] set up the CI with circle CI
- [ ] implement the project with basic code
- [ ] rebuild the project
- [ ] achievement of algorithms (BFS DFS) - the tree structure is a binary search tree
- [ ] Map and reduce(well, technically speaking, this is not Map-And-Reduce, for Map-And-Reduce is based on Stream. This one here is just task distribution)
- [ ] Blocking Queue(use blocking queue to store the urls, as producer.  Thread, on the other hand, performances like consumer)
- [ ] process single follower page information

## Map and Reduce
The whole idea of this zhihu-crawler is that use the design of Map And Reduce, which will be
processed by multiple threads of crawler, and combine all the data at the end of crawling.
First of all, I get total number I wanna crawl. Then I have to divide the number into sets.
Each thread will deal with one set or sets.

But how do I assign these tasks to each one of the threads so that per thread has the same weight task?
First of all, I use a class called TaskDistributor to do the job.