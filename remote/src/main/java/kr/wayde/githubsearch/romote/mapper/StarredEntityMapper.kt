package kr.wayde.githubsearch.romote.mapper

import kr.wayde.githubsearch.domain.entity.Starred
import kr.wayde.githubsearch.romote.model.StarredModel

class StarredEntityMapper : EntityMapper<StarredModel, Starred> {

    override fun mapFromRemote(model: StarredModel): Starred = Starred(
        model.name?:"",
        model.full_name?:"",
        model.description?:"",
        model.fork,
        model.language?:"",
        model.size,
        model.stargazers_count,
        model.forks_count,
        model.updated_at?:""
    )

}
