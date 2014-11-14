edge(freddie, isa, man).
edge(arnie, isa, man).
edge(man, ako, human).
edge(human, ako, creature).
edge(lewis, isa, penguin).
edge(penguin, ako, bird).
edge(bird,ako,creature).

property(freddie,leg,one).
property(human,leg,two).
property(penguin, fly,no).
property(bird,fly,yes).

rel(S, T, D) :- edge(S, T, D).
rel(S, isa, D) :- edge(S, isa, T), rel(T, ako, D).
rel(S, ako, D) :- edge(S, ako, T), rel(T, ako, D).

propertyrel(N, T, P) :- rel(N, isa, D), property(D, T, P).
propertyrel(N, T, P) :- rel(N, ako, D), property(D, T, P).
propertyrel(N, T, P) :- property(N, T, P),!.