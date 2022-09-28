export interface IStudyAtKorea {
  id: number;
  titleUz?: string | null;
  titleRu?: string | null;
  titleKr?: string | null;
  contentUz?: string | null;
  contentRu?: string | null;
  contentKr?: string | null;
}

export type NewStudyAtKorea = Omit<IStudyAtKorea, 'id'> & { id: null };
