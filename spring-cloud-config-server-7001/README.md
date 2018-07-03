URL与配置文件的映射关系如下：

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties

上面的url会映射{application}-{profile}.properties对应的配置文件，{label}对应git上不同的分支，默认为master。