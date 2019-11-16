package kr.wayde.githubsearch.romote.mapper

import kr.wayde.githubsearch.domain.entity.User
import kr.wayde.githubsearch.romote.model.UserModel

class UserEntityMapper : EntityMapper<UserModel, User> {

    override fun mapFromRemote(model: UserModel) = User(model.name, model.id, model.profile, model.score)

}
