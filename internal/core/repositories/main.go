package repositories

import (
	"context"

	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/core/entities"
)

type PhotosRepository interface {
	GetAll(ctx context.Context) ([]entities.PhotoEntity, error)
}

type Repositories struct {
	PhotosRepository PhotosRepository
}

func NewRepositories() *Repositories {
	return &Repositories{
		PhotosRepository: NewPhotosRepository(),
	}
}
