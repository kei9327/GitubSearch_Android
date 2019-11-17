package kr.wayde.githubsearch.romote.mapper

import kr.wayde.githubsearch.domain.entity.Repo
import kr.wayde.githubsearch.romote.model.RepoModel

class RepoEntityMapper : EntityMapper<RepoModel, Repo> {

    override fun mapFromRemote(model: RepoModel) = Repo(
        model.name?: "",
        model.full_name?: "",
        model.description?: "",
        model.fork,
        model.size,
        model.language?: "",
        model.stargazers_count,
        model.forks_count,
        model.updated_at?: ""
    )
}
