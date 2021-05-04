package services

import (
	"context"
	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/core/models"
	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/core/repositories"
)

type PhotosServiceImpl struct {
	photosRepo repositories.PhotosRepository
}

func NewPhotosService(r repositories.PhotosRepository) *PhotosServiceImpl {
	return &PhotosServiceImpl{photosRepo: r}
}

func (s *PhotosServiceImpl) GetAll(ctx context.Context) ([]models.PhotoModel, error) {
	entities, err := s.photosRepo.GetAll(ctx)
	if err != nil {

	}
	var result []models.PhotoModel
	for _, item := range entities {
		result = append(result, models.PhotoModel{
			Name:    item.Name,
			Preview: item.PhotoId,
			PhotoId: item.Preview,
		})
	}
	return result, nil
}
