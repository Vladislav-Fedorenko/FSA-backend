package repositories

import (
	"context"
	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/core/entities"
)

type PhotosRepositoryImpl struct {
}

func NewPhotosRepository() *PhotosRepositoryImpl {
	return &PhotosRepositoryImpl{}
}

func (r *PhotosRepositoryImpl) GetAll(ctx context.Context) ([]entities.PhotoEntity, error) {
	var result = []entities.PhotoEntity{
		{
			Name:    "test photo",
			Preview: "http://url",
			PhotoId: "uuid",
		},
	}
	return result, nil
}
