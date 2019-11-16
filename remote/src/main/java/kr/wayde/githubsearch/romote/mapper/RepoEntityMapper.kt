package kr.wayde.githubsearch.romote.mapper

import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.romote.model.RepoModel

class RepoEntityMapper : EntityMapper<RepoModel, Repo> {

    override fun mapFromRemote(model: RepoModel) = Repo(
        model.name,
        model.description ?: "",
        model.starCount
    )
}
