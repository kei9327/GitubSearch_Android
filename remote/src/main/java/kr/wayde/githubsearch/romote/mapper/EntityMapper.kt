package kr.wayde.githubsearch.romote.mapper

interface EntityMapper<in M, out E> {

    fun mapFromRemote(model: M): E

}
